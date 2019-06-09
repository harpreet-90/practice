package PracticeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15Medium3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
        for(int i=0; i<(nums.length); i++)
        {
        	for(int j=i+1; j<(nums.length); j++) {
        		for(int k=j+1; k<(nums.length); k++) {
        			if(i!=j && j!=k && (nums[i]+nums[j]+nums[k] == 0)) {
        				System.out.println(nums[i]+", "+nums[j]+ ", "+nums[k]);
        			}
        		}
        	}
        }
//        [[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
		return null;
    }
	public List<List<Integer>> threeSumBruteForce(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> outerList = new ArrayList<List<Integer>>();
		if(nums.length < 3) return outerList;
		int[] newNums = new int[nums.length];
		int count = 0, j=1;
		newNums[0] = nums[0];
		for(int i=1; i<nums.length; i++) {
			if((nums[i]==0 && nums[i-1]==0) && count < 3) {
				newNums[j] = nums[i];
				count++;
				j++;
			}
			else if(nums[i] == nums[i-1]) {
				if(count <2) {
					newNums[j] = nums[i];
					count++;
					j++;
				}
			}
			else {
				count = 1;
				newNums[j] = nums[i];
				j++;
			}
		}
		int length = j;
		
		int tempi = -99999999;
        for(int i=0; i<length; i++)
        {
        	if(tempi != newNums[i])
        	{
//        		tempi = nums[i];
        		int tempj = -99999999;
            	for(j=i+1; j<length; j++) {
            		
            		if(tempj != newNums[j])
            		{
            			int tempk = -99999999;
                		for(int k=j+1; k<length; k++) {
                			if(((newNums[i]+newNums[j]+newNums[k]) == 0) && (tempk != newNums[k])) 
                			{
                				System.out.println(newNums[i]+", "+ newNums[j]+", "+ newNums[k]);
                				List<Integer> innerList = new ArrayList<Integer>();
                				innerList.add(newNums[i]);
                				innerList.add(newNums[j]);
                				innerList.add(newNums[k]);
                				outerList.add(innerList);
                			}
                			tempk = newNums[k];
                		}
            		}
            		tempj = newNums[j];
            	}
        	}
        	tempi = newNums[i];
        	
        	
        }
		return outerList;
    }
	
	public List<List<Integer>> threeSumFast(int[] nums) {
		int INT_MIN = -99999999;
		Arrays.sort(nums);
		List<List<Integer>> outerList = new ArrayList<List<Integer>>();
		if(nums.length < 3) return outerList;
		int[] newNums = new int[nums.length];
		int count = 0, j=1;
		newNums[0] = nums[0];
		for(int i=1; i<nums.length; i++) {
			if((nums[i]==0 && nums[i-1]==0) && count < 3) {
				newNums[j] = nums[i];
				count++;
				j++;
			}
			else if(nums[i] == nums[i-1]) {
				if(count <2) {
					newNums[j] = nums[i];
					count++;
					j++;
				}
			}
			else {
				count = 1;
				newNums[j] = nums[i];
				j++;
			}
		}
		int length = j;
		
		int tempi = INT_MIN;
        for(int i=0; i<length; i++)
        {
        	if(tempi != newNums[i])
        	{
        		int tempj = INT_MIN;
            	for(j=i+1; j<length; j++) 
            	{
            		if(tempj != newNums[j])
            		{
            			int item = -1 * (newNums[i]+newNums[j]);
            			int k = binarySearch(j+1,length-1,item, newNums);
            			if(k != -1) 
            			{
	            			System.out.println(newNums[i]+", "+ newNums[j]+", "+ newNums[k]);
	        				List<Integer> innerList = new ArrayList<Integer>();
	        				innerList.add(newNums[i]);
	        				innerList.add(newNums[j]);
	        				innerList.add(newNums[k]);
	        				outerList.add(innerList);
            			}
                	}
            		tempj = newNums[j];
            	}
            }
        	tempi = newNums[i];
        }
        return outerList;
	}
	
	private int binarySearch(int low, int high, int item, int[] arr) {
		while(low <= high)
		{
			int mid = (low+high)/2;
			if(arr[mid] == item) {
				return mid;
			}
			else if(arr[mid] > item) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return -1;
	}
		
    
	
}
