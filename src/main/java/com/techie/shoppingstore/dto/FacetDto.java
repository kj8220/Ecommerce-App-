package com.techie.shoppingstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacetDto {
    private String facetName;
    private List<FacetValueDto> facetValueDto;
	public String getFacetName() {
		return facetName;
	}
	public void setFacetName(String facetName) {
		this.facetName = facetName;
	}
	public List<FacetValueDto> getFacetValueDto() {
		return facetValueDto;
	}
	public void setFacetValueDto(List<FacetValueDto> facetValueDto) {
		this.facetValueDto = facetValueDto;
	}
}
