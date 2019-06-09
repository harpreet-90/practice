package PracticeProblems;

import java.util.*;

public class L55 {
	
	HashMap<Integer,Boolean> hash = new HashMap<Integer,Boolean>();
    public boolean canJump(int[] nums) {
    	
    	if(nums.length <= 1) return true;
    	int length = nums.length;
    	if(nums[0] == 0) return false;
    	int sum = 0;
//    	boolean status = false;
    	int k=0;
    	while(k<length)
    	{
    		if(nums[k] == 0) return false;
    		sum = 0;
    		int i=k;
	    	while(i<=length)
	    	{
	    		if(nums[i]==0) {
	    			if(sum <= i) {
	    				break;
	    			}
	    		}
	    		else
	    		{
	    			sum = i + nums[i];
	    		}
	    		if(sum >=length-1) return true;
	    		if(i >= length-1) return true;
	    		if(sum <= i) break;
	    		i++;
	    	}
	    	
	    	k++;
    	}
        return false;
    }
    
	public boolean canJumpdp(int[] nums, int start,int length)
	{
			if(start >= length-1) return true;
			if(hash.containsKey(start) ) {
				return hash.get(start);
			}
			else
			{
				boolean ans = false;
		    	if(length <= 1) {ans = true;}
		    	else if(start >= length-1)  {ans = true;}
		    	else if(nums[start] == 0) {ans = false;}
		    	else 
		    	{
			    	for(int i=nums[start]; i>0 && !ans; i--)
			    	{
			    		ans = ans || canJumpdp(nums,start+i, length);
			    	}
		    	}
		    	hash.put(start, ans);
		        return ans;
			}
	}
	
	
	public boolean canJumpGreedy(int[] nums, int start,int length)
	{
//			if(start >= length-1) return true;
			if(hash.containsKey(start) ) {
				return hash.get(start);
			}
			else
			{
				boolean ans = false;
		    	if(length <= 1) {ans = true;}
		    	else if(start >= length-1)  {ans = true;}
		    	else if(nums[start] == 0) {ans = false;}
		    	else 
		    	{
			    	for(int i=1; i>0 && !ans; i++)
			    	{
			    		ans = ans || canJumpdp(nums,start+i, length);
			    	}
		    	}
		    	hash.put(start, ans);
		        return ans;
			}
	}
}

class Solution {
    public boolean canJump(int[] nums) {
    	
    	if(nums.length <= 1) return true;
    	int length = nums.length;
    	if(nums[0] == 0) return false;
    	int sum = 0;
    	boolean status = false;
    	int k=0;
    	while(k<length)
    	{
    		if(nums[k] == 0) return false;
    		sum = 0;
    		int i=k;
	    	while(i<=length)
	    	{
	    		if(nums[i]==0) {
	    			if(sum <= i) {
	    				break;
	    			}
	    		}
	    		else
	    		{
	    			sum = i + nums[i];
	    		}
	    		if(sum >=length-1) return true;
	    		if(i >= length-1) return true;
	    		if(sum <= i) break;
	    		i++;
	    	}
	    	
	    	k++;
    	}
        return false;
    }
    //3,0,2,8,0,0,1
}