package com.Ecommerce.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.Ecommerce.elasticsearch.ProductSearchRepository;
import com.Ecommerce.exception.ProductIndexingException;
import com.Ecommerce.model.Category;
import com.Ecommerce.model.Product;
import com.Ecommerce.repository.CategoryRepository;
import com.Ecommerce.repository.ProductRepository;

import co.elastic.clients.elasticsearch._types.query_dsl.MultiMatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductSearchRepository productSearchRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final ElasticsearchOperations elasticsearchOperations;
    private CategoryRepository categoryRepository;


    public ProductService(ProductRepository productRepository, ProductSearchRepository productSearchRepository,
			ApplicationEventPublisher eventPublisher, ElasticsearchOperations elasticsearchOperations,
			CategoryRepository categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.productSearchRepository = productSearchRepository;
		this.eventPublisher = eventPublisher;
		this.elasticsearchOperations = elasticsearchOperations;
		this.categoryRepository = categoryRepository;
	}

    @Transactional
    @CacheEvict(value = "productSearch", allEntries = true)
    public Product saveProduct(Product product) {
        try {
            Product savedProduct = productRepository.save(product);
            eventPublisher.publishEvent(savedProduct);
            productSearchRepository.save(savedProduct); // Index in Elasticsearch
            return savedProduct;
        } catch (Exception e) {
            throw new ProductIndexingException("Failed to index product in Elasticsearch" + e.getMessage(), e);
        }
    }

    @Cacheable(value = "productSearch", key = "#query")
    public List<Product> searchProducts(String query) {
        try {
            Query searchQuery = Query.of(q -> q.multiMatch(
                    MultiMatchQuery.of(m -> m
                            .query(query)
                            .fields("name", "description")
                    )
            ));

            NativeQuery nativeQuery = NativeQuery.builder()
                    .withQuery(searchQuery)
                    .build();

            SearchHits<Product> searchHits = elasticsearchOperations.search(nativeQuery, Product.class);

            return searchHits.getSearchHits().stream()
                    .map(hit -> hit.getContent())
                    .toList();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while searching products", e);
        }
    }

    @Transactional
    public void deleteProduct(Long productId) {
        try {
            if (!productRepository.existsById(productId)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
            }
            productRepository.deleteById(productId);
            productSearchRepository.deleteById(productId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete product from Elasticsearch", e);
        }
    }
    
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    
    public Page<Product> filterProducts(String category, Double minPrice, Double maxPrice, Pageable pageable) {
        Category categoryEntity = null;

        if (category != null) {
            categoryEntity = categoryRepository.findByNameIgnoreCase(category).orElse(null);
        }
        if (categoryEntity != null && minPrice != null && maxPrice != null) {
            return productRepository.findByCategoryAndPriceBetween(categoryEntity, minPrice, maxPrice, pageable);
        } else if (categoryEntity != null) {
            return productRepository.findByCategory(categoryEntity, pageable);
        } else if (minPrice != null && maxPrice != null) {
            return productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
        }

        return productRepository.findAll(pageable);
    }
}
