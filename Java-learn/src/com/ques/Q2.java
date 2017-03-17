package com.ques;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q2 {

	public static void main(String[] args) {

		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();

		compare(list1);
		compare(list2);

	}

	private static void compare(List<String> list) {

		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			list.add("hello");
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
