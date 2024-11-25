package com.techie.shoppingstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRatingDto implements Serializable {
    private String ratingId;
    @Min(1)
    @Max(5)
    private BigDecimal ratingStars;
    public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public BigDecimal getRatingStars() {
		return ratingStars;
	}
	public void setRatingStars(BigDecimal ratingStars) {
		this.ratingStars = ratingStars;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	private String review;
    private String userName;
    private String sku;
}