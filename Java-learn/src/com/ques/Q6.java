package com.ques;

class InvalidAgeException extends Exception {

	private int age;

	public void setAge(int age) {
		this.age = age;
	}

	public InvalidAgeException(int age) {
		this.age=age;
	}

	@Override
	public String getMessage() {
		return "Invalid Age to get this service : " + this.age;
	}

}

// ----------------------------------------------------

class ServiceProvider {

	public String getService(int age) throws InvalidAgeException  {

		if (age >= 18) {
			return "Welcome to our service";
		} else {
			throw  new InvalidAgeException(age);
		}

	}

}

// -----------------------------------------------------

public class Q6 {

	public static void main(String[] args) {

		System.out.println("------------------------------");
		ServiceProvider serviceProvider = new ServiceProvider();
		try {
			String resp = serviceProvider.getService(17);
			System.out.println(resp);
			System.out.println("continue with other services....");
		} catch (InvalidAgeException iae) {
			System.out.println("Ex-" + iae.getMessage());
		}
		System.out.println("------------------------------");

	}

}
