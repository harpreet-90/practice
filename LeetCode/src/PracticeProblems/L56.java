package PracticeProblems;

import java.util.*;

public class L56 {
	  public List<Interval> merge(List<Interval> it) {
	      for(int i=0; i<it.size(); i++)
	      {
	    	  if(i+1 <it.size())
	    	  {
	    		  Interval a = it.get(i);
	    		  Interval b = (i+1<it.size())?(it.get(i+1)): null;
	    		  
	    		  if(b!=null)
	    		  {
	    			 
	    		  }
	    	  }
	      }
		  return null;
	    }

	private List<Interval> inRange(Interval a, Interval b) {
		
		// TODO Auto-generated method stub
		return null;
	}
}
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */