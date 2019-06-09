package CodeChefPractice;

import java.util.Scanner;

public class CHCOINSG {
	
	public boolean isPrimeOrNot(int num)
	{
		if (num < 0) 
		{ 
			return false; 
		} 
		if (num == 0 || num == 1) 
		{ 
			return false; 
		} 
		if (num == 2 || num == 3) 
		{
			return false;
		} 
		if ((num * num - 1) % 24 == 0) 
		{ 
			return true; 
		} 
		else 
		{ 
			return false; 
		} 	
	}
	
	public void chcoinsg()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++)
		{
			int n= sc.nextInt();
			String turn= "Chef";
			if(n<6 || n%6!=0)
			{
				turn = "Chef";
			}
			else {
				turn = "Misha";
			}
			System.out.println(turn);
		}
		
	}

	
// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
// w w w l w w w w l  w  l  w  l  l
}

//15-1 = 14-2 ->12-3 ->9-1 ->8-2 ->6-2 ->4-2 ->2
//c       m     c       m    c       m    c    m 