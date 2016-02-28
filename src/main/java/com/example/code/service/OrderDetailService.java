package com.example.code.service;

import java.util.List;

import com.example.code.model.OrderDetail;
import com.example.code.model.Orders;

public interface OrderDetailService {

	List<OrderDetail> findDetailbyOrderId(int id);
	boolean addDetailsInOrder(Orders order, List<OrderDetail> orderDetailList);
	
}
