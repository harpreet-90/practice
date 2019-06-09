package PracticeProblems;

public class L6MediumProbZigZagConversion {
	
	public String convert(String s, int numRows) {
        int length = s.length();
        
		if(length == 0) return "";
        if(length <= numRows ) return s;
        
       
        String[] newString = new String[numRows];
        
        for(int i=0; i<numRows; i++) {
        	newString[i] = "";
        }
        
        int i = 0, strTrav = 0; 
        boolean flag = true;
        
        while(strTrav < length )
        {
        	if(i>=0 && i<numRows) 
        	{
        		newString[i] += s.charAt(strTrav);
        		strTrav++;
        	}
        	if(i<=0) {
        		flag = true;
        	}
        	if(i>= numRows-1) {
        		flag = false;
        	}
        	if(flag == true) {
        		i++;
        	}
        	else {
        		i--;
        	}
        	
        	
        }
        
        String zigZag = "";
        
        for(i=0;i<numRows;i++) {
        	zigZag += newString[i];
        }
        
		return zigZag;
    }
}
