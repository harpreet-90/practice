package PracticeProblems;

public class L75 {
	public void sortColors(int[] nums) {
		if(nums.length <=1) return;
		int i = 0;
		while(i<nums.length && nums[i]==0)
		{
			i++;
		}
		int j = nums.length-1;
		while(j>=0 && nums[j]==2)
		{
			j--;
		}
		int k=i+1;
		while(i<j && k<j)
		{
			while((nums[k]!=1 && (k!=i) && k!=j) && (i<j && k<j))
			{
				if(nums[k] == 0) {
					nums = swap(i,k, nums);
					i++;
				}
				else if(nums[k] == 2) {
					nums = swap(k,j,nums);
					j--;
				}
			}
			k++;
		}
		ArrayUtils au = new ArrayUtils();
		au.printArray(nums);
	}

	private int[] swap(int i, int k, int[] nums) {
		int temp = nums[k];
		nums[k] = nums[i];
		nums[i] = temp;
		return nums;
	}

}
