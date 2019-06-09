package CodeChefPractice;

import java.util.Scanner;

public class BINIM2 {
	public void binim2()
	{
		Scanner sc = new Scanner(System.in);
		long t = sc.nextLong();
		int rows = 0;
		String turn = "";
		int zeroCount = 0;
		int onesCount = 0;
		StringBuilder input = new StringBuilder("");
		for(long i=0; i<t; i++)
		{
			rows = sc.nextInt();
			turn = sc.next();
			for(int j=0; j<rows; j++)
			{
				input = new StringBuilder(sc.next());
				if(input.charAt(0) == '0')
				{
					for(int k=0; k<input.length(); k++)
					{
						if(input.charAt(k)=='0')
						{
							zeroCount += 1;
						}
					}
				}
				else
				{
					for(int k=0; k<input.length(); k++)
					{
						if(input.charAt(k)=='1')
						{
							onesCount += 1;
						}
					}
				}
			}
			
			if(zeroCount > onesCount)
			{
				System.out.println("Dum");
			}
			else if(zeroCount < onesCount)
			{
				System.out.println("Dee");
			}
			else 
			{
				if(turn.equals("Dee"))
				{
					System.out.println("Dee");
				}
				else
				{
					System.out.println("Dum");
				}
			}
		}	
	}
}
