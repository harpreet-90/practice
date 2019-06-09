package CodeChefPractice;

import java.util.Scanner;

public class MagicJar {

	public void MAGICJAR()
	{
		Scanner sc = new Scanner(System.in);
		long t = sc.nextLong();
		long max = 0;
		long chefs = 0;
		
		for(long i=0; i<t; i++)
		{
		    chefs = sc.nextLong();
		    long sum = 1;
		    for(int j=0; j<chefs; j++)
		    {
		    	sum += sc.nextLong();
		    }
		    
		    sum = sum - chefs;
		    System.out.println(sum);
		}	
	}
}
