package PracticeProblems;

public class Palindrome {

	boolean isPalindrome(String s, int start, int end) {
	
		if(start == end) return true;
		if(start == end-1) {
			if(s.charAt(start) == s.charAt(end)) return true;
			else return false;
		}
		int mid = (start+end+1)/2;
		int left = 0;
		int right = 0;
		if((end - start + 1)%2 == 0) 
		{
			left = mid-1;
			right = mid;
		}
		else 
		{
			left = mid-1;
			right = mid+1;
		}
		
		while(left >= start && right <= end)
		{
			if(s.charAt(left) != s.charAt(right)) return false;
			left--;
			right++;
		}
		
		return true;
	}
	
	public String longestPalindrome(String s) 
	{
		int length = s.length();
		if(length == 0 || length == 1) return s;
		
		String output = "";
		
		for(int i=0; i<length; i++) {
			for(int j=i; j<length; j++) {
				if(isPalindrome(s,i,j)) {
					if(output.length() < (j-i)+1 ) 
					{	output = "";
						for(int k=i;k<=j;k++) {
							output = output + s.charAt(k);
						}
					}
				}
			}
		}
		
        return output;
    }
	
	
}
