package CodeChefPractice;

import java.util.ArrayList;

public class NUMGAME2 {

	public String numGame2(int n)
	{
		// 1 for BOB's turn
		// 0 for ALICE's turn
		int turn  = 0;
		String[] turns = {"BOB", "ALICE"};
		if(n<=1) return "ALICE";
		ArrayList<Integer> arr = findAllPrimes(n);
		arr.add(1);
		int i=n, j=-1;
		while(i>0)
		{
			j= -1;
			for( j=0; j<arr.size(); j++)
			{
				if(!arr.contains(i-arr.get(j)) && (arr.get(j)<i))
				{
					break;
				}
				else if(j == arr.size()-1 )
				{
					if(turn == 1) return "ALICE";
					else return "BOB";
				}
				else if(arr.get(j) > i)
				{
					if(turn == 1) return "ALICE";
					else return "BOB";
				}
				
			}
			i = (j == -1)? 0 : i-arr.get(j); 
			if(turn == 1) turn = 0;
			else turn = 1;
		}
		if(turn == 1) return "ALICE";
		else return "BOB";
	}

	private ArrayList<Integer> findAllPrimes(int n) {
		// TODO Auto-generated method stub
		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
		return sieve.sieveOfEratosthenes(n);
	}
}
