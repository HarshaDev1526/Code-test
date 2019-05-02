package com.oes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oes.model.OrderDetails;

@Repository
public interface OrderRepository extends CrudRepository<OrderDetails, Integer> {

}
