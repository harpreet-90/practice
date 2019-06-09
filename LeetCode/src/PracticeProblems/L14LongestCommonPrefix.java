package PracticeProblems;

public class L14LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) 
	{
		if(strs.length == 0) return "";
		
		if(strs.length == 1) return strs[0];
		
		String output = strs[0];
		
		for(int i=1; i<strs.length; i++) {
			int j=0;
			String temp = "";
			while((j<strs[i].length() && j<output.length()) &&  strs[i].charAt(j) == output.charAt(j)) {
				temp += output.charAt(j);
				j++;
			}
			output = temp;
		}
		
		return output;
    }
}
