package com.oes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oes.model.Order;
import com.oes.model.OrderDetails;
import com.oes.service.OrderDetailsService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	OrderDetailsService orderDetailsService;

	@PostMapping("/save")
	public @ResponseBody String saveOrder(@RequestBody Order order, HttpServletRequest request){
		String message = "success";
		try{
			List<OrderDetails> list = orderDetailsService.prepareOrderDetails(order);
			orderDetailsService.saveOrUpdate(list);
		}catch(Exception e){
			e.printStackTrace();
			message = "failure";
		}
		return message;
	}
	
	@GetMapping("/welcome")
	public String welcome( HttpServletRequest request){
		return "Welcome";
	}
	
	@GetMapping("/orderdetails")
	public List<OrderDetails> orderDetails(HttpServletRequest request){
		return orderDetailsService.getOrderDetails();
	}
	
}
