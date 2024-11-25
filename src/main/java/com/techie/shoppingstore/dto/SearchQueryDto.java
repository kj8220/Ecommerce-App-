package com.techie.shoppingstore.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SearchQueryDto {
    private String textQuery;
    private List<Filter> filters;

    @Data
    public static class Filter implements Serializable {
        private String key;
        private String value;
        private String from;
        private String to;
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
    }
}
