package PracticeProblems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class L22 {
	public List<String> generateParenthesis(int n) {
        if(n==0) 
        	{
        	 List<String> arr = new ArrayList<String>();
             arr.add("");
        	return arr;
        	}
        List<String> arr = new ArrayList<String>();
        arr.add("()");
        for(int i=2; i<=n; i++)
        {
        	List<String> arr1 = new ArrayList<String>();
        	
        	Iterator<String> it = arr.iterator(); 
        	while(it.hasNext())
        	{
        		arr1.add("(" + it.next()+")");
        	}
        	
        	for(int j=0; j<arr.size()-1;j++)
        	{
        		arr1.add("()"+arr.get(j));
        	}
        	for(int j=0; j<arr.size();j++)
        	{
        		arr1.add(arr.get(j) + "()");
        	}
        	
        	
        	arr = arr1;
        }
        
//        Iterator<String> it = arr.iterator(); 
//    	while(it.hasNext())
//    	{
//    		System.out.println(it.next());
//    	}
//    	System.out.println("end");
		return arr;
    }
	static void _printParenthesis(char str[], int pos, int n, int open, int close) 
    { 
        if(close == n)  
        { 
            // print the possible combinations 
            for(int i=0;i<str.length;i++) 
                System.out.print(str[i]); 
            System.out.println(); 
            return; 
        } 
        else
        { 
            if(open > close) { 
                str[pos] = '}'; 
                _printParenthesis(str, pos+1, n, open, close+1); 
            } 
            if(open < n) { 
                str[pos] = '{'; 
                _printParenthesis(str, pos+1, n, open+1, close); 
            } 
        } 
    } 
      
    // Wrapper over _printParenthesis() 
    static void generateParenthesisFast(char str[], int n) 
    { 
        if(n > 0) 
        _printParenthesis(str, 0, n, 0, 0); 
        return; 
    } 
}



// ["(((())))","((()()))","((())())","(()(()))","(()()())","((()))()","(()())()","(())()()",
// "()(())()","()((()))","()(()())","()(())()","()()(())","()()()()"]

// ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())",
// "(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]


