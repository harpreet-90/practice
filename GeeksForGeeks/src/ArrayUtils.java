import java.util.*;

public class ArrayUtils {

	final int INT_MIN = -99999999;
	boolean searchInSortedMatrix(int[][] arr, int rows, int cols, int num)
	{
		if(rows == 0 && cols == 0) return false;
		int r = 0, c= cols-1;
		
		while((r>=0) && (c>=0) && (r<rows) && (c<cols))
		{
			if(arr[r][c] == num) return true;
			if(arr[r][c] > num) c--; 
			else r++;
		}
		return false;
	}
	
	void sortArrayOf012Fast(int[] arr) {
		int i,j,k;
		i=0;j= arr.length-1;k=0;
		while(i < arr.length && arr[i] == 0 ) {
			i++;
		}
		
		while( j > 0 && arr[j] == 2) {
			j--;
		}
		//0, 1, 2, 0, 1, 2, 0, 1, 2, 1, 2
		
		if(i<j) {
			k=i;
			while(k<=j)
			{
				// if we reached till here it means that our array contains 1s
				do
				{
					if(arr[k] == 0)
					{
						arr = swap(arr, i, k);
						i++;
					}
					else if(arr[k] == 2)
					{
						arr = swap(arr, k, j);
						j--;
					}
				} while(arr[k]!=1);
				k++;
			}
		}
	}
	
	void sortArrayOf012(int[] arr) {
		int length = arr.length;
		int i = 0,j = length-1; 
		while(i < arr.length && arr[i] == 0 ) {
			i++;
		}
		
		while( j > 0 && arr[j] == 2) {
			j--;
		}
		for(int k = i; (k<=j); k++) {
			while(arr[k] == 2 || arr[k] == 0) {
				if(arr[k] == 2) {
					arr = swap(arr, k, j);
					j--;
				}
				if(arr[k] == 0) {
					arr = swap(arr, i, k); 
					i++;
				}
			}
		}
		
		
	}

	public void printArray(int[] arr) {
		if(arr.length == 0) return;
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i] +" ");
		}
		
	}

	private int[] swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}
	
	void nextGreatorElement(int arr[]) {
		int length = arr.length;
		if(arr.length == 0) return;
		int[] maxEle = new int[length];
		Stack<Integer> st = new Stack<Integer>();
		
		st.push(arr[length-1]);
		maxEle[length-1] = -1;
		for(int i=length-2; i>=0; i--) {
			if(st.peek() > arr[i]) {
				maxEle[i] = st.peek();
			}
			while(!st.isEmpty() && (st.peek() <= arr[i])) {
				st.pop();
			}
			if(st.isEmpty()) {
				maxEle[i] = -1;
			}
			else {
				maxEle[i] = st.peek();
			}
			st.push(arr[i]);
		}
		printArray(maxEle);
	}
	
	int[] left  =  new int[12];
	int[] right = new int[12];
	
	public int findTrappingWater(int[] arr) {
		
		int length = arr.length;
		if(length == 0) return 0;
		
		findLeftRightMaxOfArrElements(arr);
		
		int trappedWater = 0;
		
		for(int i=0;i<length;i++) 
		{
			int min = Math.min(left[i], right[i]);
			
			if(min != arr[i] && min != -1) 
			{
				trappedWater += min - arr[i];
			}
			
		}
		
		return trappedWater;
		
	}

	private void findLeftRightMaxOfArrElements(int[] arr) {
		if(arr.length == 0) return;
		int max = -1;
		//set max in left side
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max) {
				left[i] = -1;
				max = arr[i];
			}
			else {
				left[i] = max;
			}
		}
		max = -1;
		//set max in right side
		for(int i=arr.length-1; i>=0; i--) {
			if(arr[i] > max) {
				right[i] = -1;
				max = arr[i];
			}
			else {
				right[i] = max;
			}
		}
	}
	
	void LargetSubarrayOf0sAnd1s(int[] arr) {
		if(arr.length == 0 ) return;
		int length = arr.length;
		
		// convert 0s in -1
		for(int i=0; i<length; i++) {
			if(arr[i] == 0) {
				arr[i] = -1;
			}
		}
		int sum=0, max=0;
		
		for(int i=0; i < length; i++)
		{
			sum += arr[i];
			for(int j = i+1; j<length; j++) {
				if (sum == 0 && max < j-i+1)  
	            {  
	                max = j - i + 1;   
	            }  
			}
		}
		System.out.println(max);
	}
	
	void LargetSubarrayOf0sAnd1sFast(int[] arr) {
		if(arr.length == 0 ) return;
		int length = arr.length;
		
		// convert 0s in -1
		for(int i=0; i<length; i++) {
			if(arr[i] == 0) {
				arr[i] = -1;
			}
		}
//		ArrayList<in>createHashOfLeftSum()
	}
	
	int subbArrayWithMaxSum(int[] arr) {
		if(arr.length == 0) return 0;
		
		int sum = arr[0] , max = INT_MIN;
		int i=0,j=0;
		
		while(j<arr.length) {
			if(sum > max) {
				max = sum;
				System.out.println("max=" + max);
			}
			if(sum <= 0) {
				i=j;
				sum = 0;
			}
			else {
				sum += arr[j];
				j++;
				System.out.println("incrementing j = " + j);
			}
			
		}
		return max;
	}
	
}
