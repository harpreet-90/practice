package PracticeProblems;

import java.util.*;

public abstract class L46 {
	public abstract List<Integer> permute1(char[] nums);
    static public List<List<Integer>> permute(int[] nums) {
//        createHash()
    	return null;
    }
    
   HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
    public void permute(int[] nums, int idx, String output) 
    {
    	if(idx == nums.length)
    	{
    		System.out.println(output);
    		return;
    	}
        for(int i=0; i<nums.length; i++) 
        {
        	
        	permute(nums, idx+1, output);
        }
    }
}
