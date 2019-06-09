package BankerAlgorithmPlusSemaphore;

public class Resource2 {
	int count = 2;
	int available = 2;
	String name = "resource 2";
	public boolean isAvailable()
	{
		if(available > 0) return true;
		else return false;
	}
	
	public synchronized boolean allocate(int thread)
	{
		if(available >0)
		{
			System.out.println(thread +" got resource2");
			available--;
			return true;
		}
		else
		{
			System.out.println(thread +" refused to get resource2");
			return false;
		}
	}
	
	public synchronized void release(int thread)
	{
		System.out.println("thread "+thread +" releases resource2");
		available++;
	}
}
