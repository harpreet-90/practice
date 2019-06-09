package DesignPaterns;

import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		IObservable w = new WeatherObject();
//		IObservable d = (IObservable) new DeviceList(w);
		Thread t2 = new Thread(new Runnable() 
	     { 
	         @Override
	         public void run() 
	         { 
	             try {
	            	 while(1==1)
	            	 {
	            		 w.updateAll();
	            		 Thread.sleep(1000);
	            	 }
				} catch (InterruptedException e) {
					System.out.println("exception t2.");
				} 
	         } 
	     });
	      
		t2.start();
		while(1==1)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Command...");
			int command = sc.nextInt();
			
			if(command == 0)
			{
				System.out.println("Enter name...");
				String name = sc.next();
				
				w.addObserver(new MI(w, name));
			}
			else if(command == 1)
			{
				System.out.println("Enter name...");
				String name = sc.next();
				
				w.removeObserver(name);
			}
			else {
				System.exit(0);
			}
			Thread.sleep(200);
		}
		
	}
}
