import java.util.*;

public class MathUtils {

	
	
	boolean isPrime(int n)
	{
		if(n == 2 || n == 3) return true;
		for(int i=2; i<=Math.sqrt(n); i++)
		{
			if(n%i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	void GenerateAllPrimeNumbersInGivenRange(int m, int n){
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
	
	static void sumOf3and5Multiples(int n) {
		int sum = 0;
		
		for(int i = 1; i <n; i++) {
			if(i%3 == 0 || i%5 == 0) {
				sum += i;
			}
		}
		
		System.out.println(sum);
	}
	
	public void PrimeSeive(int m , int n) {
		boolean[] arr = new boolean[n+1];
		for(int i = 0; i <= n; i++) {
			arr[i] = true;
		}
		
		arr[0] = false;
		arr[1] = false;
		
		for( int p=2; p*p<n; p++) {
			if(arr[p] == true) {
				for(int i=2; p*i<=n ; i++) {
					arr[p*i] = false;
				}
			}
		}
		
		// print all prime nos. left
		
		for(int i=m; i<=n; i++) {
			if(arr[i] == true) {
				System.out.print(i+" ");
			}
		}
	}
	
	ArrayList<Integer> hash = new ArrayList<Integer>();
	
	public void simpleSeive(int n) {
		boolean[] arr = new boolean[n+1];
		for(int i = 0; i <= n; i++) {
			arr[i] = true;
		}
		arr[0] = false;
		arr[1] = false;
		for( int p=2; p*p<n; p++) {
			if(arr[p] == true) {
				for(int i=2; p*i<=n ; i++) {
					arr[p*i] = false;
				}
			}
		}
		// print all prime nos. left
		for(int i=0; i<=n; i++) {
			if(arr[i] == true) {
				hash.add(i);
			}
		}
	}
	
	public void segmentedSeive(int n) {
		if(n<1) return;
		int limit =(int) Math.sqrt(n)+1;
		
		simpleSeive(limit);
		
		int low = limit+1;
		int high = 2*limit;
		
		while(low<n) {
			if(high > n) {
				high = n;
			}
			
			boolean mark[] = new boolean[limit + 1];
			for(int i=0; i<mark.length;i++) {
				mark[i] = true;
			}
			
			
			for(int i=0; i<hash.size(); i++) {
				int prime = hash.get(i);
				int lowLimit = (low/limit * prime);
				
				if(lowLimit < low) {
					lowLimit += prime;
				}
				
				for(int j = lowLimit; j<high; j++) {
					mark[j-lowLimit] = false;
				}
			}
			
		
		}
	}
	
	
	
	
	
}
