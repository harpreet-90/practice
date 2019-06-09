package PracticeProblems;

import java.util.Stack;

public class L20ValidParantheses {
	public boolean isValid(String s) 
	{
		if(s.length() == 0) return true;
		Stack<Character> st = new Stack<Character>();
		char c;
		for(int i=0; i<s.length(); i++) 
		{
			c = s.charAt(i);
			
			switch(c) 
			{
				case '(':
					st.push(c);
					break;
				case '{':
					st.push(c);
					break;
				case '[':
					st.push(c);
					break;
				case '}':
					if(!st.isEmpty() && st.peek() == '{') {
						st.pop();
					}
					else {
						return false;
					}
					break;
				case ')':
					if(!st.isEmpty() && st.peek() == '(') {
						st.pop();
					}
					else {
						return false;
					}
					break;
				case ']':
					if(!st.isEmpty() && st.peek() == '[') {
						st.pop();
					}
					else {
						return false;
					}
					break;
			}
		}
		
		if(st.isEmpty()) 
			return true;
		else
			return false;
    }
}
