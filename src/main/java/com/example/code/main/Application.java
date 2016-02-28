package com.example.code.main;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.code.controller.CustomerController;
import com.example.code.controller.OrderController;
import com.example.code.controller.ProductController;

public class Application {

	private static final Logger log = LogManager.getLogger(Application.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		log.info("#Application");

		Scanner scanner = new Scanner(System.in);
		int optionSelected = 1;

		System.out.println("CHOOSE THE CONTROLLER: [1] ProductController [2] CustomerController [3] OrderController");
		optionSelected = scanner.nextInt();
		log.info("Option selected: " + optionSelected + "\n");

		switch (optionSelected) {
		case 1:
			ProductController.main(args);
			break;
		case 2:
			CustomerController.main(args);
			break;
		case 3:
			OrderController.main(args);
			break;
		}

	}

}
