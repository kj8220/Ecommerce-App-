package com.techie.shoppingstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchResponseDto {
    private List<ProductDto> products;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private List<FacetDto> facetDtos;
	public List<ProductDto> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
	public BigDecimal getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}
	public List<FacetDto> getFacetDtos() {
		return facetDtos;
	}
	public void setFacetDtos(List<FacetDto> facetDtos) {
		this.facetDtos = facetDtos;
	}
}