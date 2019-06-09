package PracticeProblems;

public class L27 {
	public int removeElement(int[] nums, int val) {
        int count = 0;
         boolean flag = false;
        int i=0,j=0;
        if(nums.length >0)
        {
            if(nums[0] != val)
            {
                i++;
                count++;
            }
        }
        else{
            return 0;
        }
       
        for(j=1; j<nums.length; j++){
           if(nums[j]!=val){
                nums[i] = nums[j];
                i++;
                count++;
            }
            
        }
       return count; 
    }
}
