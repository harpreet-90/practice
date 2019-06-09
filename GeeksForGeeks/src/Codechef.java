/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
//		int i = sc.nextInt();
//		for(int j =0; j<i; j++){
//		    int m = sc.nextInt();
//		    int n = sc.nextInt();
//		    GenerateAllPrimeNumbersInGivenRange(m,n);
//		    System.out.println(primesCount(100000));
		    MathUtils mu = new MathUtils();
		    LeetCode lc =new LeetCode();
		    ListNode l1 = new ListNode(9);
		    l1.next = new ListNode(9);
		    l1.next.next = new ListNode(9);
		    l1.next.next.next = new ListNode(9);
		    ListNode l2 = new ListNode(7);
		    l2.next = new ListNode(8);
		    l2.next.next = new ListNode(6);
		    l2.next.next.next = new ListNode(4);
		    ListNode start = lc.addTwoNumbers(l1, l2);
		    while(start != null) {
		    	System.out.print(start.val + "->");
		    	start = start.next;
		    }
		    System.out.print("null");
//		    mu.sumOf3and5Multiples(1000);
//		    mu.PrimeSeive(0,1000);
	}
	static boolean isPrime(int n)
	{
		if(n < 2) return false;
		if(n == 2 || n == 3) return true;
		for(int i=2; i*i<=n; i++)
		{
			if(n%i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	static int primesCount(int n) {
		if(n < 2) return 0;
		int count = 0;
		for(int i = 1; i<=n; i++) {
			if(isPrime(i)) {
				count++;
			}
			
		}
        return count;
	}
	
	static void GenerateAllPrimeNumbersInGivenRange(int m, int n){
		if(m == 0 && n == 0 ) return;
		if(m == 0 && n==1) return ;
		if(m > n) return;
		if(n == 2) {
			System.out.println("2");
			return;
		}
		if((m==0 || m==1 )&& n > 2) 
		{
			m = 2;
		}
		
		for(int i = m; i<=n; i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
	}
}



