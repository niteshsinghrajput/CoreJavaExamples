package com.nit.multithreading;

/**
 * 
 * @author Nitesh
 * Printing Number from 1 to 100 by using two threads. One thread will be responsible to print Even Numbers 
 * and other thread will be responsible to print Odd Numbers
 */
public class MultiThreadingDemo {
	
	private static Object obj = new Object();
	
	public static void main(String[] args) {
		
		
		Thread evenThread = new Thread(new Runnable(){

			@Override
			public void run() {
				
				for(int i=0;i<=50;i++) {
					
					synchronized(obj) {
						
						obj.notifyAll();
						
						try {
							obj.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if(i%2==0){
							System.out.println("Printed By EvenThread : "+i);
						}
					}
				}
			}
			
		});
		
		Thread oddThread = new Thread(new Runnable(){

			@Override
			public void run() {
				
			for(int i=0;i<=50;i++) {
					
				synchronized(obj) {
					
					obj.notifyAll();
					
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
						if(i%2!=0){
							System.out.println("Printed By OddThread  : "+i);
						}
					}
				}
			}
			
		});
		
		evenThread.start();
		oddThread.start();
		
	}

}
