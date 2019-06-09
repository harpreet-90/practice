package PracticeProblems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class L3 {
	public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        count = 0;
        max = 0;
        int i=0, j=0, max=0, count=0;
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        while(j<s.length()) {
        	if(count > max)
        	{
        		max = count;
        	}
        	count++;	
        	if(hash.containsKey(s.charAt(j)))
        	{
        		hash.put(s.charAt(j), hash.get(s.charAt(j))+1);
        		while(hash.get(s.charAt(j)) > 1) {
        			if(hash.containsKey(s.charAt(i)) && hash.get(s.charAt(i)) >1)
        			{
        				hash.put(s.charAt(i), hash.get(s.charAt(i))-1);
        			}
        			else {
        				hash.remove(s.charAt(i));
        			}
        			i++;
    				count--;
        		}
        		if(i==j) {
        			count = 0;
        		}
        	}
        	else 
        	{
        		hash.put(s.charAt(j), 1);
        	}
        	j++;
        }
		return max;
    }
	int count=0, max=0;
	HashMap<Character, Integer> hash = new HashMap<Character,Integer>();
	
	public int lengthOfLongestSubstringModular(String s) {
		hash = new HashMap<Character,Integer>();
		max=0;count=0;
		if(s.length() == 0) return 0;
		int i=0, j=1;
		AddToHash(s.charAt(0));
		while(i<j && j<s.length()) {
			
			if(allUniqueInHash()) {
				AddToHash(s.charAt(j));
				j++;
			}
			else {
				removeFromHash(s.charAt(i));
				i++;
			}
		}
		return max;
	}
	
	private void AddToHash(char c) {
		if(hash.containsKey(c)) {
			hash.put(c, hash.get(c) + 1);
		}
		else {
			hash.put(c, 1);
			count++;
		}
		
		if(max < count)
		{
			max = count;
		}
	}
	private void removeFromHash(char c) {
		if(hash.containsKey(c)) {
			int val = hash.get(c);
			if(val == 1)
			{
				hash.remove(c);
				count--;
			}
			else
			{
			hash.put(c, val-1);
			}
		}
	}
	
	private boolean allUniqueInHash() {
		Iterator it = hash.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry me = (Map.Entry)it.next();
		    if((int)me.getValue() > 1) {
		    	return false;
		    }
		}
		return true;
	}
}
