package com.techie.shoppingstore.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.CompletionField;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.completion.Completion;

import java.math.BigDecimal;
import java.util.List;

// Document used to store products in ElasticSearch
@Document(indexName = "product")
@Data
public class ElasticSearchProduct {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String sku;
    private String imageUrl;
    private Category category;
    @Field(type = FieldType.Nested)
    private List<ProductAttribute> productAttributeList;
    private Integer quantity;
    private String manufacturer;
    private boolean featured;
    @CompletionField(maxInputLength = 100)
    private Completion suggestions;
    private List<ProductRating> productRating;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<ProductAttribute> getProductAttributeList() {
		return productAttributeList;
	}
	public void setProductAttributeList(List<ProductAttribute> productAttributeList) {
		this.productAttributeList = productAttributeList;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public boolean isFeatured() {
		return featured;
	}
	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	public Completion getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(Completion suggestions) {
		this.suggestions = suggestions;
	}
	public List<ProductRating> getProductRating() {
		return productRating;
	}
	public void setProductRating(List<ProductRating> productRating) {
		this.productRating = productRating;
	}
}
