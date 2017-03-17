package com.shop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.bill.Billing;

public class App {

	public static void main(String[] args) {

		// Init
		ConfigurableApplicationContext applicationContext = null;
		applicationContext = new ClassPathXmlApplicationContext("application_layer.xml");

		// Use

		List<String> cart = new ArrayList<>();
		cart.add("234567");
		cart.add("687678");

		Billing billComp = applicationContext.getBean("billComp1", Billing.class);

		double totalPrice = billComp.getTotalPrice(cart);
		System.out.println(totalPrice);

		// Destroy
		applicationContext.close();

	}

}
