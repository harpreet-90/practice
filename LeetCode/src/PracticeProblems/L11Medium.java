package PracticeProblems;

public class L11Medium {
	public int maxArea(int[] height) {
        int max = 0;
        int length = height.length;
        int limit =0;
        for(int i=0; i<length-1; i++)
        {
        	for(int j = i+1; j<length;j++)
        	{
        		limit = Math.min(height[i], height[j])  * (j-i);
        		if(limit > max) max = limit;
        	}
        }
        return max;
    }
}
