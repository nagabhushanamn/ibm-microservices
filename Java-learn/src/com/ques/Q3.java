package com.ques;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Owner {
	private String name;

	public Owner(String name) {
		super();
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owner other = (Owner) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
}

class Car {

	private String model;
	private String color;

	@Override
	public String toString() {
		return "Car [model=" + model + ", color=" + color + "]";
	}

	public Car(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((model == null) ? 0 : model.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Car other = (Car) obj;
//		if (model == null) {
//			if (other.model != null)
//				return false;
//		} else if (!model.equals(other.model))
//			return false;
//		return true;
//	}

}

public class Q3 {

	public static void main(String[] args) {

		Car car1 = new Car("Audi", "black");
		Car car2 = new Car("BMW", "white");
		
		
		Owner owner1=new Owner("Nag");
		Owner owner2=new Owner("Ria");
		
		

		// System.out.println(car1.hashCode());
		// System.out.println(car2.hashCode());
		//
		// System.out.println(car1.equals(car2));
		//
		// Set<Car> cars = new HashSet<>();
		// cars.add(car1);
		// cars.add(car2);
		//
		// System.out.println(cars.size());

		
		Map<Owner, Car> map=new HashMap<>();
		map.put(owner1, car1);
		map.put(owner2, car2);
		

		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter owner name?");
		
		String name=sc.nextLine();
		
		Owner key=new Owner(name);
		
		Car car=map.get(key);
		
		
		if(car!=null){
			System.out.println(car);
		}else{
			System.out.println("dream it..");
		}
		
		sc.close();
		
	}

}
