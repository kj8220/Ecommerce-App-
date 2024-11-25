package com.techie.shoppingstore.dto;

import com.techie.shoppingstore.model.ProductAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private String productName;
    private String imageUrl;
    private String sku;
    private BigDecimal price;
    private String description;
    private String manufacturer;
    private ProductAvailability availability;
    private List<ProductAttribute> attributeList;
    private boolean featured;
    private List<ProductRatingDto> productRatingDtoList;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public ProductAvailability getAvailability() {
		return availability;
	}
	public void setAvailability(ProductAvailability availability) {
		this.availability = availability;
	}
	public List<ProductAttribute> getAttributeList() {
		return attributeList;
	}
	public void setAttributeList(List<ProductAttribute> attributeList) {
		this.attributeList = attributeList;
	}
	public boolean isFeatured() {
		return featured;
	}
	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	public List<ProductRatingDto> getProductRatingDtoList() {
		return productRatingDtoList;
	}
	public void setProductRatingDtoList(List<ProductRatingDto> productRatingDtoList) {
		this.productRatingDtoList = productRatingDtoList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
