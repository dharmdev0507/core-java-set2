package com.dev.java21;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreadMain {

	public static void main(String[] args) {

		System.out.println("## Start -> "+Thread.currentThread().getName());
		
		//create virtual thread by startVirtualThread
		var vt=Thread.startVirtualThread(()->{
			
			for(int i=1;i<=10;i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    System.out.println("## count : "+i);	
			}
			
		});
		
		try {
			vt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("## End -> "+Thread.currentThread().getName());
		
		
		//create virtual thread by ofVirtual method 
		var vt1=Thread.ofVirtual().name("virtual-thread").start(()->{
		     
			  System.out.println("Inside Thread Name : "+Thread.currentThread().getName());
		});
		
		System.out.println("Outside Thread Name : "+vt1.getName());
		
		try {
			vt1.join();
		}catch (Exception e) {
			System.out.println("Exception : "+e);
		}
		
		
		//3 create virtual thread by Executor frameworks
		
		try(ExecutorService executor=Executors.newVirtualThreadPerTaskExecutor()){
			
			Future<String> future=executor.submit(()->{
				
				for(int i=1;i<=10;i++) {
					System.out.println("##count --> "+i);
				}
				
				
				return "Virtual thread "+Thread.currentThread();
			});
			
			System.out.println(future.get());
			System.out.println(future.isCancelled());
			System.out.println(future.isDone());
			
		}catch(Exception e) {
			
		}
		
	}

}
