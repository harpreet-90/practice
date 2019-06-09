package ObserverPattern;

import java.util.Scanner;

import DesignPaterns.MI;

public class Main1 {

	public static void main(String[] args) throws InterruptedException 
	{
		
	IObservable w = new WeatherStation();
	
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
			
			w.add(new PhoneDisplay(name,w));
		}
		else if(command == 1)
		{
			System.out.println("Enter name...");
			String name = sc.next();
			
			w.add(new PhoneDisplay(name,w));
		}
		else if(command == 2)
		{
			System.out.println("Enter name...");
			String name = sc.next();
			
			w.remove(name);
		}
		else if(command == 3){
			System.out.println("Enter Temperature to change...");
			int temp = sc.nextInt();
			
			w.setTemperature(temp);;
		}
		
		else {
			System.exit(0);
		}
		Thread.sleep(200);
	}
	
	
	}
}
