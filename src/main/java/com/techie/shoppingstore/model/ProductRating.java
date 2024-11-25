package com.techie.shoppingstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRating {
    private String id;
    @Min(1)
    @Max(5)
    private BigDecimal ratingStars;
    private String productId;
    private String elasticSearchProductId;
    private String review;
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getRatingStars() {
		return ratingStars;
	}
	public void setRatingStars(BigDecimal ratingStars) {
		this.ratingStars = ratingStars;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getElasticSearchProductId() {
		return elasticSearchProductId;
	}
	public void setElasticSearchProductId(String elasticSearchProductId) {
		this.elasticSearchProductId = elasticSearchProductId;
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
	private String userName;
}
