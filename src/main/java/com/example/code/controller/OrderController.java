package com.example.code.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.code.model.OrderDetail;
import com.example.code.model.Orders;
import com.example.code.service.OrderDetailService;
import com.example.code.service.OrderService;
import com.example.code.service.impl.OrderDetailServiceImpl;
import com.example.code.service.impl.OrderServiceImpl;

public class OrderController {

	private static final Logger log = LogManager.getLogger(OrderController.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		log.info("#OrderController");

		OrderController controller = new OrderController();

		Scanner scanner = new Scanner(System.in);
		int optionSelected = 1;

		System.out.println("TYPE THE NUMBER IN THE CONSOLE TO EXECUTE METHOD: [1] generateOrderWithDetails");
		optionSelected = scanner.nextInt();
		log.info("Option selected: "+ optionSelected + "\n");

		switch (optionSelected) {
		case 1:
			controller.generateOrderWithDetails();
			break;
		}

	}

	public void generateOrderWithDetails() {

		// Master
		OrderService orderService = new OrderServiceImpl();
		Orders order = new Orders();
		order.setCustomerId(1);
		int id = orderService.createOrder(order);

		// Get master id
		Orders actualOrder = orderService.findOrderById(id);
		OrderDetailService orderDetailService = new OrderDetailServiceImpl();
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>(); // detail
																			// list

		OrderDetail orderDetail = null;
		{
			orderDetail = new OrderDetail();
			orderDetail.setProductId(1);
			orderDetail.setQuantity(randomQuantity());
			orderDetail.setUnitPrice(orderDetail.getProduct().getUnitPrice());
			orderDetailList.add(orderDetail);

			orderDetail = new OrderDetail();
			orderDetail.setProductId(2);
			orderDetail.setQuantity(randomQuantity());
			orderDetail.setUnitPrice(orderDetail.getProduct().getUnitPrice());
			orderDetailList.add(orderDetail);

			orderDetail = new OrderDetail();
			orderDetail.setProductId(3);
			orderDetail.setQuantity(randomQuantity());
			orderDetail.setUnitPrice(orderDetail.getProduct().getUnitPrice());
			orderDetailList.add(orderDetail);
		}
		orderDetailService.addDetailsInOrder(actualOrder, orderDetailList);
		orderService.updateOrderWithOrderDetail(actualOrder);
	}

	int randomQuantity() {

		int max = 20;
		int min = 5;

		int value = (int) (Math.random() * ((max - min) + 1)) + min;

		return value;

	}

}
