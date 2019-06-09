package PracticeProblems;

import java.util.*;

public class L17 {
	
	
	String[] hash = {" ","*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	List<String> ans = new ArrayList<String>();
	public List<String> letterCombinations(String digits) {
		ans.clear();
		letterCombinations(digits, "", 0);
		System.out.println();
		return ans;
    }

	private void letterCombinations(String digits, String output, int idx) {
		if(digits.length() == 0) return;
		if(output.length() == digits.length())
		{
			//System.out.print(output + ",");
			 ans.add(output);
			 return;
		}
		int val = Character.getNumericValue(digits.charAt(idx));
		for(int i=0; i<hash[val].length(); i++)
		{
			letterCombinations(digits, output+(hash[val].charAt(i)), idx+1);
		}
	}
	
}
