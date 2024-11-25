package com.techie.shoppingstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Document(collection = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String sku;
    private String imageUrl;
    private Category category;
    private Long categoryId;
    private List<ProductAttribute> productAttributeList;
    private Integer quantity;
    private String manufacturer;
    private boolean featured;
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
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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
	public List<ProductRating> getProductRating() {
		return productRating;
	}
	public void setProductRating(List<ProductRating> productRating) {
		this.productRating = productRating;
	}
}
