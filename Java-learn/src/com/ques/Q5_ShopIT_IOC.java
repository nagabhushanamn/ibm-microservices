package com.ques;

import java.util.ArrayList;
import java.util.List;

/*
 *  shopIT
 *  --------
 *  
 *   1. PriceMatrix   : getPrice(item)
 *   2. Billing       : getTotalPrice(cart)
 * 
 */

//----------------------------------------------

// PriceMatrix - module

interface PriceMatrix {
	double getPrice(String item);
}

class NewPriceMatrixImpl_v1 implements PriceMatrix {

	public double getPrice(String item) {
		// ....
		return 100.00;
	}

}

class NewPriceMatrixImpl_v2 implements PriceMatrix {

	public double getPrice(String item) {
		// ....
		return 200.00;
	}

}

// ----------------------------------------------

interface Billing {
	public double getTotalPrice(List<String> cart);
}

class NewBillingImpl implements Billing {

	private PriceMatrix priceMatrix;

	public NewBillingImpl(PriceMatrix priceMatrix) {
		this.priceMatrix = priceMatrix;
	}

	public double getTotalPrice(List<String> cart) {

		double total = 0.0;

		for (String item : cart) {
			total += priceMatrix.getPrice(item);
		}

		return total;

	}

}

// ----------------------------------------------

public class Q5_ShopIT_IOC {

	public static void main(String[] args) {

		// Some-one ==> component-manager/container

		// init-phase

		PriceMatrix priceMatrixV2 = new NewPriceMatrixImpl_v2();
		PriceMatrix priceMatrixV1 = new NewPriceMatrixImpl_v1();

		Billing billComp = new NewBillingImpl(priceMatrixV1);

		// use-phase

		List<String> cart = new ArrayList<>();
		cart.add("234567");
		cart.add("687678");

		double totalPrice = billComp.getTotalPrice(cart);
		System.out.println(totalPrice);

		// destroy-phase
		billComp = null;

	}

}
