package BankerAlgorithmPlusSemaphore;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ObserverPattern.PhoneDisplay;
public class Main {
	static int i = 0;
	static Resource1 R1= new Resource1();
	static Resource2 R2 = new Resource2();
	public static void main(String[] args) {
//		final int threadCount = 6;
//		final ExecutorService exService = Executors.newFixedThreadPool(threadCount);
//		final Library library = new Library();
//		for(int i=0; i < threadCount; i++) {
//			Reader reader = new Reader(library);
//			exService.execute(reader);
//		}
//		exService.shutdown();
		
		Thread[] threads = new Thread[10];
		for( i=0; i<10; i++)
		{
			threads[i]= new Thread(new Runnable() 
		    { 
				int val = i;
				boolean r1 = false, r2 = false;
				
		        @Override
		        public void run() 
		        { 
		            try {
		           	 while(1==1)
		           	 {
		           		 System.out.println("thread "+ val +" trying to access ");
		           		 r1 = (r1 == false)?R1.allocate(val): true;
		           		Thread.sleep(1000);
		           		 r2 = (r2 == false)?R2.allocate(val): true;
		           		 if(r1 && r2)
		           		 {
		           			Thread.sleep(5000);
		           			R1.release(val);
		           			Thread.sleep(200);
		           			R2.release(val);
		           			break;
		           		 }
		           		 else {
		           			 System.out.println("thread "+val+" going to sleep.");
		           		 }
		           		 Thread.sleep(1000);
		           	 }
					} catch (InterruptedException e) {
						System.out.println("exception t2.");
					} 
		        } 
		    });
			threads[i].start();
		}
		
		while(1==1)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Command...");
			int command = sc.nextInt();
			
			if(command == 0)
			{
				System.out.println("Enter name...");
				String name = sc.next();
				
//				w.add(new PhoneDisplay(name,w));
			}
			else if(command == 1)
			{
				System.out.println("Enter name...");
				String name = sc.next();
				
//				w.add(new PhoneDisplay(name,w));
			}
			else if(command == 2)
			{
				System.out.println("Enter name...");
				String name = sc.next();
				
//				w.remove(name);
			}
			else if(command == 3){
				System.out.println("Enter Temperature to change...");
				int temp = sc.nextInt();
				
//				w.setTemperature(temp);;
			}
			
			else {
				System.exit(0);
			}
//			Thread.sleep(200);
		}
		
		
	}
} 