package BankerAlgorithmPlusSemaphore;

public class Resource1 {

	int count = 2;
	int available = 2;
	String name = "resource 1";
	public boolean isAvailable()
	{
		if(available > 0) return true;
		else return false;
	}
	
	public synchronized boolean allocate(int thread)
	{
		if(available >0)
		{
			System.out.println(thread +" got resource1");
			available--;
			return true;
		}
		else
		{
			System.out.println(thread +" refused to get resource1");
			return false;
		}
	}
	
	public synchronized void release(int thread)
	{
		System.out.println("thread "+thread +" releases resource1");
		available++;
	}
}
