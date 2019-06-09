package PracticeProblems;

public class L28StrStr {
	 public int strStr(String haystack, String needle)
	 {
		 if((haystack.length() == 0 && needle.length() == 0) || (haystack.length() != 0 && needle.length() == 0)) return 0;
	     
		 if(haystack.length() == 0) return -1;
		 
		 int firstOcr = -1, j = 0;
		 for(int fstOcr=0; j<needle.length(); fstOcr++) {
			 for(int i=0; j<needle.length(); i++) {
				 if(i >= haystack.length()) return -1;
		    	 if(haystack.charAt(i) == needle.charAt(j)) {
		    		 if(j==0) {
		    			 firstOcr = i;
		    			 fstOcr = firstOcr;
		    		 }
		    		 j++;
		    	 }
		    	 else {
		    		 j = 0;
		    		 firstOcr = -1;
		    		 i = fstOcr;
		    	 }
		     }
			 if(firstOcr !=-1)
			 return firstOcr;
		 }
		 return -1;
	 }
	 
	 public int strStrSlow(String haystack, String needle)
	 {
		 if((haystack.length() == 0 && needle.length() == 0) || (haystack.length() != 0 && needle.length() == 0)) return 0;
	     
		 if(haystack.length() == 0) return -1;
		 
		 int firstOcr = -1;
		 for(int i=0; i<haystack.length(); i++) 
		 {	int k = 0;
			 for(int j=i; k<needle.length(); j++)
			 {
				 if(j >= haystack.length()) {
					 firstOcr =-1;
					 break;
				 }
				 if(haystack.charAt(j) == needle.charAt(k)) {
					 if(j==i) {
						 firstOcr = j;
					 }
					 k++;
				 }
				 else {
					 firstOcr = -1;
					 break;
				 }
			 }
			 if(firstOcr != -1) return firstOcr;
		 }
		 
		 return firstOcr;
	 }
	 
	 public int strStrFast(String haystack, String needle)
	 {
		 if((haystack.length() == 0 && needle.length() == 0) || (haystack.length() != 0 && needle.length() == 0)) return 0;
		 if(haystack.length() < needle.length()) return -1;
	     
		 for(int i=0; i<haystack.length(); i++) 
		 {	
			 int k = i;
			 int j=0;
			 while(k < haystack.length() && j<needle.length() && haystack.charAt(k) == needle.charAt(j))
			 {
				 k++;j++;
			 }
			 if(j==needle.length())
				 return i;
		 }
		 
		 return -1;
	 }
}
