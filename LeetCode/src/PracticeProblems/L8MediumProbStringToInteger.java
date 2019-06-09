package PracticeProblems;

public class L8MediumProbStringToInteger {
    public int myAtoi(String str) {
        int length = str.length();
        if(length == 0) return 0;
        
        int i=0;
        boolean signFound = false, numFound = false;
        
        String s = "";
        long ans = 0;
        boolean flag = true;
        
        while(i < length) {
        	char c = str.charAt(i);
        	if((c>='0' && c<='9') || c=='-' || c=='+') {
        		if(c == '-' && signFound == false && numFound==false)
        		{
        			signFound = true;
        			flag = false;
        		}
        		else if(c == '+' && signFound == false && numFound==false)
        		{
        			signFound = true;
        			flag = true;
        		}
        		else if((c=='-' || c=='+') && signFound == true) {
        			break;
        		}
        		else if((c=='-' || c=='+') && (signFound == true || numFound == true)) {
        			break;
        		}
        		else if(c !='+' && c !='-'){
        			if(ans >= 2147483647) break;
        			ans = ans*10 + Character.getNumericValue(c);
        			numFound = true;
        		}
        		
        		i++;
        	}
        	else if(str.charAt(i) == ' ')
        	{
        		if(numFound==true  || signFound==true) break;
        		i++;
        	}
        	else {
        		if(ans > 2147483647)
        		{
        			if(flag == false) return -2147483648;
        			else return 2147483647;
        		}
        		if(flag == false)
        		{
        			ans = (-1)*ans;
        		}
        		return (int) ans;
        	}
        }
        if(ans > 2147483647)
		{
			if(flag == false) return -2147483648;
			else return 2147483647;
		}
        if(flag == false)
		{
			ans = (int) (-1)*ans;
		}
		return (int)ans;
        
    }
}


/*
42
-2147483648
-1
1
0
123
*/