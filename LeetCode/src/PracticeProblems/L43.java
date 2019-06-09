package PracticeProblems;

public class L43 {
	
	int carry = 0;
	String apendZeros = "";
	 public String multiply(String num1, String num2) 
	 {
		 apendZeros ="";
		 if(num1.length()==0 || num2.length()==0) return "0";
		 if(num1.equals("0") || num2.equals("0")) return "0";
		 int i=(num1.length()-1); 
		 String ans = "";
		 while(i>=0)
		 {
			 String addToAns = multiplyStringWithChar(num2, num1.charAt(i));
			 addToAns = addToAns + apendZeros;
			 ans = addTwoNums(ans, addToAns);
			 i--;
			 apendZeros += "0";
		 }
		 
		 return ans;
	 }
	private String addTwoNums(String s1, String s2) {
		if(s1 == null || s1 == "") return s2;
		if(s2 == null || s2 == "") return s1;
		carry = 0;
		int l1 = s1.length()-1, l2 = s2.length()-1;
		if(l1 < l2)
		{
			String temp = s1;
			s1 = s2;
			s2 = temp;
			l1 = l1+l2;
			l2 = l1 - l2;
			l1 = l1 - l2;
			
		}
		int a=0,b=0;
		String ans = "";
		while(l1>=0 && l2>=0)
		{
			a = Character.getNumericValue(s1.charAt(l1));
			b = Character.getNumericValue(s2.charAt(l2));
			
			int c = a+b+carry;
			carry = c/10;
			if(l1 == 0) {
				ans = c+ ans;
			}
			else {
				ans = (c%10) + ans;
			}
			
			l1--;
			l2--;
		}
		while(l1 >= 0) {
			a = Character.getNumericValue(s1.charAt(l1));
			int c = a+carry;
			carry = c/10;
			
			if(l1 == 0) {
				ans = c+ ans;
			}
			else {
				ans = (c%10) + ans;
			}
			l1--;
		}
		
		return ans;
	}
	private String multiplyStringWithChar(String num, char c) {
		carry = 0;
		if(num == null) return "0";
		if(c == '0') return "0";
		int a = Character.getNumericValue(c);
		int length = num.length()-1;
		String ans = "";
		while(length>=0)
		{
			int b = Character.getNumericValue(num.charAt(length));
			int multi = a*b + carry;
			carry = multi/10;
			if(length == 0) {
				ans = multi+ ans;
			}
			else {
				ans = (multi%10) + ans;
			}
			length--;
		}
		return ans;
	}
}
