package com.oes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductById {
	private int statusCode;
	private Product body;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Product getBody() {
		return body;
	}
	public void setBody(Product body) {
		this.body = body;
	}
}
