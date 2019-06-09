package PracticeProblems;
//26. Remove Duplicates from Sorted Array
public class L26 {
	public int removeDuplicates(int[] nums) {
        int prev = -999999999, count = 0, j = 0 ;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != prev){
                nums[j] = nums[i];
                j++;
                count++;
                prev = nums[i];
            }
        }
        return count;
    }
}
