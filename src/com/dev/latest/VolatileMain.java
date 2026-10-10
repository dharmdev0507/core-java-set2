package com.dev.latest;

class TestVolatile{
	
	private volatile boolean flag=true;
	
	public void run() {
		
		while(flag) {
			System.out.println("Thread is currently running");
		}
		
		System.out.println("Thread stops now");
	}
	
	public void stop() {
		flag=false;
		System.out.println("Stop method: executed");
	}
	
}

public class VolatileMain {

	public static void main(String[] args) {
		
		TestVolatile obj=new TestVolatile();
		
		Thread t1=new Thread(obj::run);
		Thread t2=new Thread(obj::stop);
		
		t1.start();
		t2.start();
	}

}
