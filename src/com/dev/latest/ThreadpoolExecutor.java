package com.dev.latest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadpoolExecutor {

	public static void main(String[] args) {
	
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
			    2,                      // core threads
			    5,                      // maximum threads
			    60,                     // keep-alive time
			    TimeUnit.SECONDS,
			    new LinkedBlockingQueue<>(100)
			);
		

		for (int i = 1; i <= 110; i++) {
		    int taskId = i;
		    executor.execute(() -> {
		    	
		        System.out.println(
		            "Task " + taskId +
		            " executed by " + Thread.currentThread().getName()
		        );

		        try {
		            Thread.sleep(5000);
		        } catch (InterruptedException e) {
		            Thread.currentThread().interrupt();
		        }
		    });
		}
	}

}
