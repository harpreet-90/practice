package PracticeProblems;

public class L9 {

	boolean reverseInt(long x) {
		if(x<0) return false;
		else {
			L7ReverseNumber l7 = new L7ReverseNumber();
			long reverse = (long) l7.reverse((int)x);
			if(x == reverse)
				return true;
			else 
				return false;
		}
	}
}
