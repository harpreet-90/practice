package PracticeProblems;

import java.util.HashMap;

public class L13RomanToInt {
	public int romanToInt(String s) 
	{
        HashMap<Character,Integer> hash = new HashMap<Character, Integer>();
		hash.put('n', 1);
		hash.put('o', 5);
		hash.put('p', 10);
		hash.put('q', 50);
		hash.put('r', 100);
		hash.put('s', 500);
		hash.put('t', 1000);
		s = s.replace('I', 'n');
		s = s.replace('V', 'o');
		s = s.replace('X', 'p');
		s = s.replace('L', 'q');
		s = s.replace('C', 'r');
		s = s.replace('D', 's');
		s = s.replace('M', 't');
		int sum = 0;
		for(int i=0; i<s.length();i++)
		{
			if(i+1 < s.length()) 
			{
				char a = s.charAt(i);
				char b = s.charAt(i+1);
				if(a < b) 
				{
					sum += (hash.get(b)-hash.get(a));
					i++;
				}
				else 
				{
					sum += hash.get(a);
				}
			}
			else 
			{
				char a = s.charAt(i);
				sum += hash.get(a);
			}
		}
		
		return sum;
    }

	private int convertToInteger(char c) {
		return (int) c;
	}
}
