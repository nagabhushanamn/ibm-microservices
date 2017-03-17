package com.ques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Product implements Comparable<Product> {

	private int id;
	private String name;
	private double price;

	public Product() {
	}

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Product o) {
		if (this.price == o.price) {
			return 0;
		} else if (this.price > o.price) {
			return 1;
		} else {
			return -1;
		}
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

}

public class Q1 {

	public static void main(String[] args) {

		Product product1 = new Product(74234234, "Laptop", 1000.00);
		Product product2 = new Product(56743534, "Mobile", 6000.00);
		Product product3 = new Product(96785637, "Apple", 2000.00);

		List<Product> products = new ArrayList<>();

		products.add(product1);
		products.add(product2);
		products.add(product3);

		// --------------------------------------------------------------

		// Collections.sort(products); // sort by price( natural property )

		// sort by Name

		// Collections.sort(products, new Comparator<Product>() {
		// @Override
		// public int compare(Product o1, Product o2) {
		// return o1.getName().compareTo(o2.getName());
		// }
		// });

		// java-8 : Lambda Expression
		Collections.sort(products, (Product o1, Product o2) -> {
			return o1.getName().compareTo(o2.getName());
		});

		display(products);

	}

	private static void display(List<Product> products) {
		for (Product product : products) {
			System.out.println(product);
		}
	}

	// private class ProductsByName implements Comparator<Product> {
	// @Override
	// public int compare(Product o1, Product o2) {
	// return o1.getName().compareTo(o2.getName());
	// }
	//
	// }
	//
	// private class ProductsById implements Comparator<Product> {
	//
	// @Override
	// public int compare(Product o1, Product o2) {
	// if (o1.getId() == o2.getId()) {
	// return 0;
	// } else if (o1.getId() > o2.getId()) {
	// return 1;
	// } else {
	// return -1;
	// }
	// }
	//
	// }

}
