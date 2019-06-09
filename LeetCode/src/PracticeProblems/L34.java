package PracticeProblems;

public class L34 {
	public int[] searchRange(int[] nums, int target) 
	{

		int[] ans = {-1, -1};
		
		ans[0] = searchStart(nums, target);
		if(ans[0] == -1) return ans;
		else
			ans[1] = searchEnd(nums,target);
        return ans;
    }

	private int searchEnd(int[] nums, int target) {
		int low = 0;
		int length = nums.length;
		int high = nums.length -1;
		 while(low <= high)
		 {
			 int mid = (low+high)/2;
			 if(mid == length-1) {
				 return (nums[mid] == target)? mid : -1;
			 }
			 else if(nums[mid]== target && nums[mid+1] > nums[mid])
			 {
				 return mid;
			 }
			 else if(nums[mid] <= target) {
				 low = mid+1;
			 }
			 else {
				 high = mid - 1;
			 }
		 }
		
		return -1;
	}

	private int searchStart(int[] nums, int target) {
		int low = 0;
		int high = nums.length -1;
		if(nums.length ==2) {
			 return (nums[0]== target)? 0: ((nums[1]== target)? 1: -1);
		}
		 while(low <= high)
		 {
			 int mid = (low+high)/2;
			 if(mid == 0) {
				 return (nums[mid] == target)? mid : -1;
			 }
			 else if(nums[mid]== target && nums[mid-1] < nums[mid])
			 {
				 return mid;
			 }
			 else if(nums[mid] >= target) {
				 high = mid-1;
			 }
			 else {
				 low = mid+1;
			 }
		 }
		
		return -1;
	}
}
