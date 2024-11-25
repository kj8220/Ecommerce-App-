package com.techie.shoppingstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacetValueDto {
    private String facetValueName;
    private Integer count;
	public String getFacetValueName() {
		return facetValueName;
	}
	public void setFacetValueName(String facetValueName) {
		this.facetValueName = facetValueName;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
