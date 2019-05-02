package com.oes.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oes.model.Product;
import com.oes.model.ProductById;
import com.oes.model.Products;

@Service
public class OesClient {
	
	
	public String getData(String url){
		String body = null;
		CloseableHttpClient client = HttpClientBuilder.create().build();
		try {
			CloseableHttpResponse res = client.execute(new HttpGet(url));
			res.setHeader("content-type", MediaType.APPLICATION_JSON.toString());
			int statusCode = res.getStatusLine().getStatusCode();
			if(statusCode != 200) throw new RuntimeException("Invalid status code "+statusCode);
			body = EntityUtils.toString(res.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}
	
	public Products getProducts(){
		Products products = null;
		String data  = getData("https://vrwiht4anb.execute-api.us-east-1.amazonaws.com/default/product/");
		try {
			products = new ObjectMapper().readValue(data, Products.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public Product getProductById(String id){
		ProductById productById = null;
		String data = getData("https://vrwiht4anb.execute-api.us-east-1.amazonaws.com/default/product/"+id);
		try {
			productById = new ObjectMapper().readValue(data, ProductById.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return productById.getBody();
	}

}
