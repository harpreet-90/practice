package PracticeProblems;

import java.util.*;

public class L54 {
	public List<Integer> spiralOrder(int[][] arr) 
	{
	     if(arr.length==0) return new ArrayList<Integer>();
	     int rows = arr.length;
	     int cols = arr[0].length;
	     List<Integer> output = new  ArrayList<Integer>();
	     int r=0, c=0;
	     int limit = (r>c)?c:r;
	     if(limit%2 == 0)
	     {
	    	 limit = (limit/2)-1;
	     }
	     else {
	    	 limit = limit/2;
	     }
	     rows--;
	     cols--;
	     while(r <= limit/2)
	     {
	    	 output = printBox(r,c,rows, cols,output, arr);
	    	 r++;c++;
	     }
	     System.out.println(output.toString());
		return output;
    }

	private List<Integer> printBox(int r, int c, int rows, int cols, List<Integer> output, int[][] arr) {
		int row = r;
		int col = c;
		
		for(col=c; col<(cols-c); col++)
		{
			output.add(arr[r][col]);
		}
		for(row = r; row<=(rows-r); row++)
		{
			output.add(arr[row][cols-c]);
		}
		for(col= cols-c;col>=c && (col != cols-c);col--)
		{
			output.add(arr[rows-r][col]);
		}
		for(row = rows-r; row>r && (row != rows-r); row--)
		{
			output.add(arr[row][c]);
		}
		return output;
	}

}
