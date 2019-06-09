package PracticeProblems;

import java.util.*;

public class L39 {
	List<List<Integer>> li = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum(int[] candidates, int target)
	{
		li.add(allCombination(candidates,0, candidates.length-1, target));
		return  li;
	}
	
	public List<Integer> allCombination(int[] candidates,int start, int end, int target)
	{
		List<Integer> lli = new ArrayList<Integer>();
		for(int i=0; i<candidates.length; i++)
		{
			
			if(target%candidates[start] == 0)
				{
					int count = target/candidates[start];
					while(count>0)
					{
						lli.add(candidates[start]);
						count--;
					}
					li.add(lli);
				}
			lli = combination(candidates, i, candidates.length-1, target,);
			if(lli.size() !=0)
			{
				li.add(lli);
			}
		}
		return lli;
	}
	public ArrayList<Integer> combination(int[] candidates,int start, int end, int target, boolean original)
	{
		
		ArrayList<Integer> lli = new ArrayList<Integer>();
		if(start>end) {
			
		}
		else if(start==end)
		{
			
			if(target==candidates[start])
			{
				lli.add(candidates[start]);
			}
			else if(target%candidates[start] == 0)
			{
				int count = target%candidates[start];
				while(count>0)
				{
					lli.add(candidates[start]);
					count--;
				}
			}
		}
//		else if(target%candidates[start] == 0)
//		{
//			int count = target/candidates[start];
//			while(count>0)
//			{
//				lli.add(candidates[start]);
//				count--;
//			}
//		}
		else 
		{
			
			int a = candidates[start];
//			lli.add(candidates[start]);
//			if(target%candidates[start] == 0)
//				{
//					int count = target/candidates[start];
//					while(count>0)
//					{
//						lli.add(candidates[start]);
//						count--;
//					}
//					return lli;
//				}
			while(a<=target)
			{
				int b = candidates[start];
				lli.add(b);
				List<Integer> temp = new ArrayList<Integer>();
				if(a!=target)
				 temp = allCombination(candidates, start+1, end, target-a, false);
				if(temp.size() != 0)
				{
					lli.addAll(temp);
				}
				int sum =0;
				for(int i=0;i<lli.size(); i++)
				{
					sum += lli.get(i);
				}
				if(sum == target && original==true)
				{
					li.add(lli);
					lli.removeAll(temp);
				}
//				
				a = a+a;
			}
			int sum =0;
			for(int i=0;i<lli.size(); i++)
			{
				sum += lli.get(i);
			}
			if(sum != target)
			{lli = new ArrayList<Integer>();}
		}
		return lli;
	}
	
	void printList(List<Integer> l)
	{
		System.out.print("[");
		for(int i=0; i<l.size();i++)
		{
			if(i!=0)
				System.out.print(",");
			
			System.out.print(l.get(i));
		}
		System.out.println("]");
	}
}
