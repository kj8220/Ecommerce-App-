package com.techie.shoppingstore.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShoppingCartItem {
    private String name;
    private BigDecimal price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
