package PracticeProblems;

public class L33 {
	
	public int search(int[] nums, int target) {
		int length = nums.length;
		if(length == 0) return -1;
		if(target == nums[0]) return 0;
		if(target == nums[length-1]) return length-1;
		
		int start = FindSortedArrayStart(nums, 0, nums.length-1);
		System.out.println("start = "+start);
		
		if(target > nums[length-1])
			return binarySearch(nums, 0, start-1, target);
		else
			return binarySearch(nums, start, length-1, target);
    }
	
	int binarySearch(int[] arr, int low, int high, int item) {
		while(low <= high)
		{
			int mid = high - (high-low)/2;
			if(item == arr[mid])
				return mid;
			else if(item < arr[mid])
				high = mid-1;
			else
				low = mid + 1;
		}
		return -1;
	}
	
	int FindSortedArrayStart(int[] rotated, int low, int high)
	{
		
		int mid = -1;
		int length = rotated.length;
		if(length == 0) return -1;
		else if(length == 1) return 0;
		else if(length == 2) return Math.min(rotated[0], rotated[1]);
		if(rotated[0] <= rotated[length-1]) return 0;
		while(low <= high)
		{ 
			if(low == high) {
				 return low;
			}
			mid = (low+high)/2;
			if(mid == 0) {
				return (rotated[mid] <= rotated[mid+1])? mid : mid+1;
			}
			else if(rotated[mid] <= rotated[mid-1] && rotated[mid] <= rotated[mid+1] )
			{
				return mid;
			}
			if(rotated[mid] >= rotated[high])
			{
				low = mid+1;
			}
			else
			{
				high = mid-1;
			}
		}
		
		return mid;
	}
}
