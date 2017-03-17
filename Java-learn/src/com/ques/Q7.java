package com.ques;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * 
 *  java development-style
 *  
 *  
 * 	components
 * 
 * 	container
 * 
 */

//----------------------------------------------------------------------

// Container_provider  ( e.g spring )

@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.METHOD })
@interface RequestMapping {
	String url();

	String method();
}

class Container {

	public void processRequest(String url) {

		Class clazz = null;
		try {
			clazz = Class.forName("com.ques.ComponentOne");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Method[] methods = clazz.getMethods();

		for (Method method : methods) {
			RequestMapping anno = method.getAnnotation(RequestMapping.class);
			if (anno != null) {
				String givenUrl = anno.url();
				if (url.equals(givenUrl)) {
					try {
						Object componentOne = clazz.newInstance();
						method.invoke(componentOne, null);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}

// ----------------------------------------------------------------------

// Component(s)

class ComponentOne {

	@RequestMapping(url = "/login", method = "POST")
	public void login() {
		System.out.println("do Login..");
	}

	@RequestMapping(url = "/register", method = "POST")
	public void doRegister() {
		System.out.println("do Register..");
	}

}

public class Q7 {

	public static void main(String[] args) {

		Container container = new Container();
		container.processRequest("/login");
		container.processRequest("/register");

	}

}
