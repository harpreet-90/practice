package PracticeProblems;

public class L36 {
	    boolean[] hash = {false,false,false,false,false,false,false,false,false,false};
	    
	   public boolean isValidSudoku(char[][] board) {
	        
	    	return isValidRowCol(board) && isValidGrids(board);
	    }

		private boolean isValidGrids(char[][] board) {
			int l = board.length;
			for(int i=0; i<board.length; i = i+3)
			{
				resetHash();
				for(int j=0;j<3; j++)
				{
					for(int k=i;k<i+3;k++) 
					{
						if(isValid(board[k][j]) == false)
						{
							return false;
						}
					}
				}
				resetHash();
				for(int j=3;j<6; j++)
				{
					for(int k=i;k<i+3;k++) 
					{
						if(isValid(board[k][j]) == false)
						{
							//System.out.println("returning false");
							return false;
						}			
					}
				}
				resetHash();
				for(int j=6;j<9; j++)
				{
					for(int k=i;k<i+3;k++)
					{
						if(isValid(board[k][j]) == false)
						{
							//System.out.println("returning false");
							return false;
						}			
					}
				}
			}
			
			return true;
		}
		
		boolean isValid(char cc)
		{
			int c = Character.getNumericValue(cc);
			if((c != -1) && hash[c] == false)
			{
				hash[c] = true;
				return true;
			}
			else if(c != -1) {
				//System.out.println("returning false");
				return false;
			}
	        else{
	            return true;
	        }
	        
		}
		
		private void resetHash()
		{
			for(int i=0; i< hash.length; i++) {
				hash[i] = false;
			}
		}
		private boolean isValidRowCol(char[][] board) {
			// validate rows
			for(int i=0; i< board.length; i++) {
				resetHash();
				for(int j=0; j< board[i].length; j++)
				{
					int c = Character.getNumericValue(board[i][j]);
					if((c != -1) && hash[c] == false) {
						hash[c] = true;
					}
					else if((c != -1)){
						//System.out.println("returning false");
						return false;
					}
				}
			}
			
			// validate cols
					for(int i=0; i< board.length; i++)
					{
						resetHash();
						for(int j=0; j< board[i].length; j++)
						{
							int c = Character.getNumericValue(board[j][i]);
							if((c != -1) && hash[c] == false) {
								hash[c] = true;
							}
							else if(c != -1) {
								//System.out.println("returning false");
								return false;
							}
						}
					}
			return true;
		}
	}