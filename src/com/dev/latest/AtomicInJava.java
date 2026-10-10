package com.dev.latest;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInJava {


	public static void main(String[] args) {
		
		AtomicInteger count = new AtomicInteger(10);
		System.out.println(count.incrementAndGet()); // 11
		System.out.println(count.decrementAndGet()); // 10
		System.out.println(count.getAndIncrement()); // returns 10, then becomes 11
		System.out.println(count.addAndGet(5));      // adds 5
		System.out.println(count.get());             // gets current value
		count.set(100);          // sets value
		System.out.println(count.get());
	}
}
