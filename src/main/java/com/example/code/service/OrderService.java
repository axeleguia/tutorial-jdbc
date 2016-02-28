package com.example.code.service;

import com.example.code.model.Orders;

public interface OrderService {

	int createOrder(Orders order);
	Orders findOrderById(int id);
	boolean updateOrderWithOrderDetail(Orders order);
	
}
