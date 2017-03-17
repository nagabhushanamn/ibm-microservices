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

class PriceMatrixImpl_v1 {

	public double getPrice(String item) {
		// ....
		return 100.00;
	}

}
class PriceMatrixImpl_v2 {

	public double getPrice(String item) {
		// ....
		return 200.00;
	}

}

// ----------------------------------------------

// Billing - module

/*
 * 
 *  design and performance issues
 *  ------------------------------
 *  
 *  
 *   --> tight-coupling b/w dependent and dependency.
 *   
 *   		- can't with new features, refactoring difficult...
 *   		
 *   --> too many same dependency created & destructed
 *   
 *   		- memory , exe slow , etc..
 *   		
 *   --> Unit-Testing not possible
 *   
 *          - dev slow , bug fix diffcult..
 *          
 *     
 *         
 *    why these issues happening here ?
 *    
 *         - creating dependency-obj in dependent's class
 *    
 *         
 *     soln :
 *     
 *      don't create dependency in dependent's class, 
 *      do lookup & get reference
 *         
 *        
 *      limitation of lookup:
 *      
 *         - location tight-coupling
 *         
 *      best-soln:
 *      
 *        don't create & lookup dependency , get/inject thru some-one ( IOC )
 *        
 *        
 *        how to implement IOC?
 *        
 *          --> Dependency Injection ( DI )
 *          
 *          	--> constructor DI
 *              --> setter DI
 *          
 *          --> AOP
 *          
 *       ----------------------------------------------------------------   
 *        
 *        
 *         
 * 
 */

class BillingImpl {

	private PriceMatrixImpl_v1 priceMatrix;

	public double getTotalPrice(List<String> cart) {

		double total = 0.0;
		priceMatrix = new PriceMatrixImpl_v1();

		for (String item : cart) {
			total += priceMatrix.getPrice(item);
		}

		return total;

	}

}

// ----------------------------------------------

public class Q5_ShopIT {

	public static void main(String[] args) {

		// init-phase
		BillingImpl billComp = new BillingImpl();

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
