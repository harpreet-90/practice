
public class MustDo {
//Array
	//1.
	Pair<int,int> subbArrayWithGivenSum(int arr[], int sum)
	{
		
		// i=j=0
		// while j<len increase j if currSum is less
		// or increase i if currSum is greater
		// return if equal
		// test
		
		
		if(arr.length == 0 || sum < 0) return new pair(-1,-1);
		
		int i=0, j=0, length = arr.length;
		int currSum = 0;
		while(j < length){
			if(currSum == sum) return new Pair<int, int>(i,j);
			if(currSum < sum){
				currSum += arr[j];
				j++;
			}
			if(currSum >sum){
				currSum -= arr[i];
				i++;
			}
		}
	}

}
