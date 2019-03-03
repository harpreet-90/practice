
public class RomanToInt {
	public void RomanToInteger(String romanNo)
	{
		if(romanNo == null) return;
		int length = romanNo.length();
		romanNo = romanNo.replace('I', 'P');
		romanNo = romanNo.replace('V', 'Q');
		romanNo = romanNo.replace('X', 'R');
		romanNo = romanNo.replace('L', 'S');
		romanNo = romanNo.replace('D', 'T');
		romanNo = romanNo.replace('C', 'U');
		romanNo = romanNo.replace('M', 'V');
		
		int i=0, sum =0 ;
		while((i+1)<length ) {
			if(romanNo.charAt(i) >= romanNo.charAt(i+1)) {
				sum += getIntValue(romanNo.charAt(i));
				i++;
			}
			else {
				sum += (getIntValue(romanNo.charAt(i+1)) - getIntValue(romanNo.charAt(i)));
				i += 2;
			}
		}
		if(i < length) {
			sum += getIntValue(romanNo.charAt(i));
		}
		System.out.println(sum);
	}
	
	int getIntValue(char c) {
		switch(c) {
		case 'P':
			return 1;
		case 'Q':
			return 5;
		case 'R':
			return 10;
		case 'S':
			return 50;
		case 'T':
			return 100;
		case 'U':
			return 500;
		case 'V':
			return 1000;
		}
		return -1;
	}
	
	
}
