package PracticeProblems;
//Rotate Image
public class L48 {
	String str = "jbsxjs";
	
    public void rotate(int[][] arr) {

     int n = arr.length;
     n = n-1;
     int row = 0, col = 0;
     while((n > 1) && row <= n/2) {
    	 int i=row, j=row;
    	 int temp = -1;
    	 while((i < (n-row)) && (j < n-col))
    	 {
    		 temp = arr[i][n-col];
    		 arr[i][n-col] = arr[row][j];
    		 
    		 arr[row][j] = temp;
    		 temp = arr[n-row][n-j];
    		 arr[n-row][n-j] = arr[row][j];
    		 
    		 arr[row][j]= temp;
    		 temp = arr[n-i][col];
    		 arr[n-i][col] = arr[row][j];
    		 
    		 arr[row][j] = temp;
    		 i++; j++;
    	 }
    	 row++; col++;
     }
     
     printMatrix(arr);
    }

	private void printMatrix(int[][] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		System.out.println("[");
		for(int i=0; i<n; i++) {
			System.out.print("[");
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j]);
				if(j != n-1)
				{
					System.out.print(", ");
				}
			}
			System.out.print("]");
			if(i != n-1)
			{
				System.out.println(", ");
			}
		}
		System.out.println();
		System.out.println("]");
	}
}

// 7 4 1 
// 8 5 2
// 9 6 3

