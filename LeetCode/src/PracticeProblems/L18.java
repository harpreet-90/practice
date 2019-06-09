package PracticeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L18 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		int INT_MIN = -99999999;
		Arrays.sort(nums);
		List<List<Integer>> outerList = new ArrayList<List<Integer>>();
		if(nums.length < 3) return outerList;
		
		ArrayList<Integer> newNums = RemoveDuplicatesMoreThan4(nums);
		int length = newNums.size();
		
		int tempi = INT_MIN;
        for(int i=0; i<length; i++)
        {
        	if(tempi != newNums.get(i))
        	{
        		int tempj = INT_MIN;
            	for(int j=i+1; j<length; j++) 
            	{
            		if(tempj != newNums.get(j))
            		{
            			int tempk = INT_MIN;
            			for(int k=j+1; k<length; k++)
            			{
            				if(tempk != newNums.get(k))
            				{
		            			int item = target - (newNums.get(i)+newNums.get(j) +newNums.get(k));
		            			int l = binarySearch(k+1,length-1,item, newNums);
		            			if(l != -1) 
		            			{
			            			System.out.println(newNums.get(i)+", "+ newNums.get(j)+", "+ newNums.get(k)+", "+ newNums.get(l));
			        				List<Integer> innerList = new ArrayList<Integer>();
			        				innerList.add(newNums.get(i));
			        				innerList.add(newNums.get(j));
			        				innerList.add(newNums.get(k));
			        				innerList.add(newNums.get(l));
			        				outerList.add(innerList);
		            			}
            				}
            				tempk = newNums.get(k);
            			}
                	}
            		tempj = newNums.get(j);
            	}
            }
        	tempi = newNums.get(i);
        }
        return outerList;
	}
	private ArrayList<Integer> RemoveDuplicatesMoreThan4(int[] nums) {
		ArrayList<Integer> newNums = new ArrayList<Integer>();
		int count = 0, j=1;
		newNums.add(nums[0]);
		count = 1;
		for(int i=1; i<nums.length; i++) {
			if(nums[i] == nums[i-1]) {
				if(count <4) 
				{
					newNums.add(nums[i]);
					count++;
					j++;
				}
			}
			else 
			{
				count = 1;
				newNums.add(nums[i]);
				j++;
			}
		}
		return newNums;
	}
	
	private int binarySearch(int low, int high, int item, ArrayList<Integer> arr) {
		while(low <= high)
		{
			int mid = (low+high)/2;
			if(arr.get(mid) == item) {
				return mid;
			}
			else if(arr.get(mid) > item) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
