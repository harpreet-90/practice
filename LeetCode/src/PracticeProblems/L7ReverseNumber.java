package PracticeProblems;

public class L7ReverseNumber {
	public int reverse(int x) {
		if(x>2147483647 || x< -2147483648) return 0;
		
		boolean negFlag = false;
		if(x<0) {
			negFlag = true;
			x *= (-1);
		}
		long newNum = 0;
		while(x > 0) {
			newNum = newNum*10 + (x%10);
			x = x/10;
		}
		if(newNum>(2147483647) || newNum<  -2147483648) return 0;
		if(negFlag == true)
			return (int) (-1*newNum);
		else
			return ((int) newNum);
	}
}
