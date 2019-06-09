package CodeChefPractice;

import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class ATM {
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	public void atm()
	{
		Scanner sc = new Scanner(System.in);
		double withdrwalAmt = sc.nextDouble();
		double totalAmt = sc.nextDouble();
		
		if((withdrwalAmt%5 == 0) && (withdrwalAmt+0.50) <= totalAmt)
			totalAmt = totalAmt - withdrwalAmt - 0.50; 
		System.out.printf("%.2f\n",(totalAmt));
		//System.out.println(df2.format(totalAmt));
		
		
		
	}
}
