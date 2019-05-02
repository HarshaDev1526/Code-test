package com.oes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oes.http.OesClient;
import com.oes.model.Item;
import com.oes.model.Order;
import com.oes.model.OrderDetails;
import com.oes.model.Product;
import com.oes.repository.OrderRepository;

@Component
public class OrderDetailsService {

	@Autowired
	OrderRepository repository;

	@Autowired OesClient client;

	public void saveOrUpdate(List<OrderDetails> list){
		repository.saveAll(list);
	}

	public List<OrderDetails> getOrderDetails(){
		List<OrderDetails> list = new ArrayList<OrderDetails>();
		repository.findAll().forEach(od -> list.add(od));
		return list;
	}

	public List<OrderDetails> prepareOrderDetails(Order order) {
		List<OrderDetails> list = new ArrayList<OrderDetails>();
		List<Item> items = order.getItems();
		System.out.println("Items :: "+items);
		for(Item i: items){
			OrderDetails details = new OrderDetails();
			Product product = client.getProductById(i.getProductId());
			if( product != null) {
				details.setCustomerId(order.getCustomerId());
				details.setName(product.getName());
				details.setPrice(product.getPrice());
				details.setProductId(i.getProductId());
				details.setQuantity(i.getQuantity());
				details.setTotal(i.getQuantity() * product.getPrice());
				list.add(details);
			}
		}
		return list;
	}
}
