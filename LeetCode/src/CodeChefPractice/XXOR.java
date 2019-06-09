package CodeChefPractice;

import java.util.*;

public class XXOR {
	public void xxor()
	{
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long q = sc.nextLong();
		long arr[] = new long[(int) n];
		long queryLeft[] = new long[(int) q];
		long queryRight[] = new long[(int) q];
		for(int i=0; i<n;i++)
		{
			arr[i] = sc.nextLong();
		}
		for(int i=0;i<q; i++)
		{
			queryLeft[i] = sc.nextLong();
			queryRight[i] = sc.nextLong();
		}	
		for(int qq=0; qq<q ; qq++)
		{
			long min = arr[(int)queryLeft[qq]-1];
			for(int i=(int)queryLeft[qq]; i<(int)queryRight[qq]; i++)
			{
				if(min > arr[i])
				{
					min = arr[i];
				}
			}
			long max = (min^2147483647);
			int maxX = 2147483647;
			int x;
			for(x=2147483646; (x>0); x--)
			{
				if(max < (min^x))
				{
					max = min^x;
					maxX = x;
				}
			}
			System.out.println(maxX);
		}
	}
	public void xxor1()
	{
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long q = sc.nextLong();
		long arr[] = new long[(int) n];
		long queryLeft[] = new long[(int) q];
		long queryRight[] = new long[(int) q];
		for(int i=0; i<n;i++)
		{
			arr[i] = sc.nextLong();
		}
		for(int i=0;i<q; i++)
		{
			queryLeft[i] = sc.nextLong();
			queryRight[i] = sc.nextLong();
		}
		boolean status;
		long min = arr[0];
		for(int i=1; i<n; i++)
		{
			if(min > arr[i])
			{
				status = false;
				for(int j=0; j<q; j++)
				{
					if((queryLeft[j] <= i )&& queryRight[j] >= i)
					{
						status = true;
						break;
					}
				}
				if(status == true)
				{
					min = arr[i];
				}
			}
			
		}
		
		System.out.println(min);
	}
}
