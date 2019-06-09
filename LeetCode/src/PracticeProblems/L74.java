package PracticeProblems;
//search in sorted array
public class L74 {
	boolean searchInSortedMatrix(int[][] arr, int rows, int cols, int num)
	{
		if(rows == 0 && cols == 0) return false;
		int r = 0, c= cols-1;
		
		while((r>=0) && (c>=0) && (r<rows) && (c<cols))
		{
			if(arr[r][c] == num) return true;
			if(arr[r][c] > num) c--; 
			else r++;
		}
		return false;
	}
	
	 public boolean searchMatrix(int[][] matrix, int target) 
	 {
		 int rows = matrix.length;
		 int cols = (rows == 0)?0:matrix[0].length;
		 if(rows == 0 && cols == 0) return false;
		 
		 int r = 0, c= cols-1;
			
		while((r>=0) && (c>=0) && (r<rows) && (c<cols))
		{
			if(matrix[r][c] == target) return true;
			if(matrix[r][c] > target) c--; 
			else r++;
		}
	     return false;
	 }
}
