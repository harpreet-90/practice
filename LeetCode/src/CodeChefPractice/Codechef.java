package CodeChefPractice;

import java.util.*;

//import com.sun.java_cup.internal.runtime.Scanner;

public class Codechef {

	public static void main(String[] args) 
	{
		XXOR x = new XXOR();
		x.xxor();
//      1024.00000
//		101787950545501729778875062915906507380623346042197229174784000.00000
//		inf
//		ATM a = new ATM();
//		a.atm();
//		BINIM2 bn = new BINIM2();
//		bn.binim2();
//		
//		MIXCOLOR mx = new MIXCOLOR();
//		mx.mixColor();
//		MagicJar mg = new MagicJar();
//		mg.MAGICJAR();
//		NUMGAME2 ng = new NUMGAME2();
//		Scanner sc = new Scanner(System.in);2147483627   
//                                          2147483638
//		int t = sc.nextInt();
//		for(int i=0; i<t;i++)
//		{
//			int n = sc.nextInt();
//			System.out.println(ng.numGame2(n));
//		}
		
	}
}
//class NUMGAME2 {
//
//	public String numGame2(int n)
//	{
//		// 1 for BOB's turn
//		// 0 for ALICE's turn
//		int turn  = 0;
//		String[] turns = {"BOB", "ALICE"};
//		if(n<=3) return "BOB";
//		ArrayList<Integer> arr = findAllPrimes(n);
//		int i=n, j=-1;
//		while(i>0)
//		{
//			j= -1;
//			for( j=0; j<arr.size(); j++)
//			{
//				if(!arr.contains(i-arr.get(j)))
//				{
//					break;
//				}
//				else if(j == arr.size()-1)
//				{
//					if(turn == 1) return "ALICE";
//					else return "BOB";
//				}
//				
//			}
//			i = (j == -1)? 0 : i-arr.get(j); 
//			if(turn == 1) turn = 0;
//			else turn = 1;
//		}
//		if(turn == 1) return "ALICE";
//		else return "BOB";
//	}
//
//	private ArrayList<Integer> findAllPrimes(int n) {
//		// TODO Auto-generated method stub
//		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
//		return sieve.sieveOfEratosthenes(n);
//	}
//}
// public class SieveOfEratosthenes 
// { 
// 	ArrayList<Integer> sieveOfEratosthenes(int n) 
//     { 
//         // Create a boolean array "prime[0..n]" and initialize 
//         // all entries it as true. A value in prime[i] will 
//         // finally be false if i is Not a prime, else true. 
//         boolean prime[] = new boolean[n+1]; 
//         for(int i=0;i<n;i++) 
//             prime[i] = true; 
//           
//         for(int p = 2; p*p <=n; p++) 
//         { 
//             // If prime[p] is not changed, then it is a prime 
//             if(prime[p] == true) 
//             { 
//                 // Update all multiples of p 
//                 for(int i = p*p; i <= n; i += p) 
//                     prime[i] = false; 
//             } 
//         } 
//           
//         // Print all prime numbers 
//         ArrayList<Integer> primes = new ArrayList<Integer>(); 
//         for(int i = 2; i <= n; i++) 
//         { 
//             if(prime[i] == true) 
//                 primes.add(i); 
//         } 
//         return primes;
//     }
// }
