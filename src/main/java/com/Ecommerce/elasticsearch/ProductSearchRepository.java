package com.Ecommerce.elasticsearch;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.model.Product;
@Repository
public interface ProductSearchRepository extends ElasticsearchRepository<Product, Long> {
    List<Product> findByNameContainingOrDescriptionContaining(String name, String description);

}