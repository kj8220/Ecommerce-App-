	package com.Ecommerce.controller;
	
	import java.util.List;
	
	import org.springframework.cache.annotation.Cacheable;
	import org.springframework.data.domain.Page;
	import org.springframework.data.domain.PageRequest;
	import org.springframework.data.domain.Pageable;
	import org.springframework.data.domain.Sort;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.model.Category;
import com.Ecommerce.model.Product;
	import com.Ecommerce.service.ProductService;
	
	@RestController
	@RequestMapping("/api/products")
	public class ProductController {
	
	    private final ProductService productService;
	
	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }
	
	    @PostMapping("/add")
	    public Product addProduct(@RequestBody Product product) {
	        return productService.saveProduct(product);
	    }
	
	    @GetMapping("/search")
	    public List<Product> searchProducts(@RequestParam String query) {
	        return productService.searchProducts(query);
	    }
	    
	    @GetMapping
	    @Cacheable(value = "allProducts", key = "#page + '-' + #size + '-' + #sortBy + '-' + #order")
	    public ResponseEntity<Page<Product>> getAllProducts(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size,
	            @RequestParam(defaultValue = "name") String sortBy,
	            @RequestParam(defaultValue = "asc") String order) {
	
	        Pageable pageable = PageRequest.of(page, size, Sort.by(
	                order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sortBy));
	        
	        Page<Product> products = productService.getAllProducts(pageable);
	        
	        return ResponseEntity.ok(products);
	    }
	    
	    @GetMapping("/filter")
	    public ResponseEntity<Page<Product>> filterProducts(
	            @RequestParam(required = false) String category,
	            @RequestParam(required = false) Double minPrice,
	            @RequestParam(required = false) Double maxPrice,
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size,
	            @RequestParam(defaultValue = "name") String sortBy,
	            @RequestParam(defaultValue = "asc") String order) {

	        Pageable pageable = PageRequest.of(page, size, Sort.by(
	                order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sortBy)
	        		);

	        Page<Product> products = productService.filterProducts(category, minPrice, maxPrice, pageable);
	        
	        return ResponseEntity.ok(products);
	    }

	}
	
