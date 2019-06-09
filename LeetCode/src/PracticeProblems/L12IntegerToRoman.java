package PracticeProblems;

import java.util.*;

public class L12IntegerToRoman {
	HashMap<Integer,String> hash = new HashMap<Integer,String>();
	
	L12IntegerToRoman()
	{
//		add 0 to 10 values
		hash.put(0, "");
		hash.put(1, "I");
		hash.put(2,"II");
		hash.put(3,"III");
		hash.put(4,"IV");
		hash.put(5,"V");
		hash.put(6,"VI");
		hash.put(7,"VII");
		hash.put(8,"VIII");
		hash.put(9,"IX");
		hash.put(10,"X");
		hash.put(20,"XX");
		hash.put(30,"XXX");
		hash.put(40,"XL");
		hash.put(50,"L");
		hash.put(60,"LX");
		hash.put(70,"LXX");
		hash.put(80,"LXXX");
		hash.put(90,"XC");
		hash.put(100,"C");
		hash.put(200,"CC");
		hash.put(300,"CCC");
		hash.put(400,"CD");
		hash.put(500,"D");
		hash.put(600,"DC");
		hash.put(700,"DCC");
		hash.put(800,"DCCC");
		hash.put(900,"CM");
		hash.put(1000,"M");
		hash.put(2000,"MM");
		hash.put(3000,"MMM");	
	}
	
	public String intToRoman(int num) 
	{
		int mod = 1;
		String ans =  hash.get(num%10);
		num = num-(num%10);
		while(num>0 && num/mod > 1)
		{
			mod *= 10;
			int modVal = (num/mod);
			int val = (modVal%10)*mod;
//			System.out.print(val+" -> ");
			ans = hash.get(val) + ans;
			num = num - (val);
		}
		
		return ans;
	}

}
