package PracticeProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class L16 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		if(nums.length < 3) return 0;
		int INT_MIN = -99999999;
		int INT_MAX = 99999999;
		int closest = INT_MAX;
		int minDiff = INT_MAX;
		ArrayList<Integer> newNums = RemoveDuplicatesMoreThan3(nums);
        int tempi = INT_MIN;
		for(int i=0; i<newNums.size(); i++) 
		{
			if(tempi != newNums.get(i))
			{
				int tempj = INT_MIN;
				for(int j=i+1; j<newNums.size();j++) 
				{
					if(tempj != newNums.get(j))
					{
						int tempk = INT_MIN;
						for(int k=j+1; k<newNums.size(); k++)
						{
							if(tempk != newNums.get(k))
							{
								int sum = newNums.get(i)+ newNums.get(j)+newNums.get(k);
								int diff;
								if(sum < 0)
								{
									diff = sum - target;
								}
								else {
									diff = sum -target;
								}
								if(diff == 0) return sum;
								if(diff < 0 )
								{
									diff = (diff * (-1));
								}
								if(diff < minDiff)
								{
									System.out.println(i+"+"+j+"+"+k+"="+sum);
									closest = sum;
									minDiff = diff;
								}
							}
							tempk = newNums.get(k);
						}
					}
					tempj = newNums.get(i);
				}
			}
			tempi = newNums.get(i);
		}
        
        
		return closest;
    }

	private ArrayList<Integer> RemoveDuplicatesMoreThan3(int[] nums) {
		ArrayList<Integer> newNums = new ArrayList<Integer>();
		int count = 0, j=1;
		newNums.add(nums[0]);
		count = 1;
		for(int i=1; i<nums.length; i++) {
			if(nums[i] == nums[i-1]) {
				if(count <3) 
				{
					newNums.add(nums[i]);
					count++;
					j++;
				}
			}
			else 
			{
				count = 1;
				newNums.add(nums[i]);
				j++;
			}
		}
		return newNums;
	}
}
