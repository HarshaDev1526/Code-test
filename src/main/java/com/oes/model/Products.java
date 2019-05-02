package com.oes.model;

import java.util.List;

public class Products {
	private int statusCode;
	private List<Product> body;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public List<Product> getBody() {
		return body;
	}
	public void setBody(List<Product> body) {
		this.body = body;
	}
}
