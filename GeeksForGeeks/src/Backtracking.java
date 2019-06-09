public class Backtracking {

	final int MAX = 4;
	int[][] matrix;
	boolean ElementIsPlacedInRow[];
	boolean ElementIsPlacedInCol[];

	Backtracking() {
		matrix = new int[MAX][MAX];
		ElementIsPlacedInRow = new boolean[MAX];
		ElementIsPlacedInCol = new boolean[MAX];

	}

	void printPermutation() {
		printPermutations(0);
	}

	private void printMatrix() {
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				System.out.print(matrix[i][j] + " ");

			}
			System.out.println();
		}
		System.out.println();
	}

	private void printPermutations(int row) {
		if (row == MAX) {
			printMatrix();
			return;
		}
		if (row > MAX || row < 0) {
			return;
		} else {
			for (int i = 0; i < MAX; i++) {
				if (canPlace(row, i)) {
					ElementIsPlacedInRow[row] = ElementIsPlacedInCol[i] = true;
					matrix[row][i] = i + 1;
					printPermutations(row + 1);
					matrix[row][i] = 0;
					ElementIsPlacedInRow[row] = ElementIsPlacedInCol[i] = false;
				}
			}
		}
	}

	private boolean canPlace(int row, int col) {
		return !ElementIsPlacedInRow[row] && !ElementIsPlacedInCol[col];
	}

	private boolean canPlaceQueen(int row, int col) {
		return (!ElementIsPlacedInRow[row] && !ElementIsPlacedInCol[col] && isDiagonalSafe(row, col));
	}

	//
	//
	private boolean isDiagonalSafe(int row, int col) {
		int r = row, c = col;
		// left diagonal
		while (r >= 0 && c >= 0) {
			if (matrix[r][c] != 0)
				return false;
			r--;
			c--;
		}
		// right diagonal
		r = row;
		c = col;
		while (r >= 0 && c < MAX) {
			if (matrix[r][c] != 0)
				return false;
			r--;
			c++;
		}
		return true;
	}

	private boolean allPlaced() {
		for (int i = 0; i < MAX; i++) {
			if (ElementIsPlacedInRow[i] == false) {
				return false;
			}
		}
		return true;
	}

	void nQueen(int row) {
		if (allPlaced()) {
			printMatrix();
			return;
		}
		if (row == MAX) {
			return;
		}

		if (row > MAX || row < 0) {
			return;
		}

		for (int i = 0; i < MAX; i++) {

			if (canPlaceQueen(row, i)) {
				ElementIsPlacedInRow[row] = true;
				ElementIsPlacedInCol[i] = true;
				matrix[row][i] = 1;
				nQueen(row + 1);
				matrix[row][i] = 0;
				ElementIsPlacedInRow[row] = false;
				ElementIsPlacedInCol[i] = false;
			}
		}
	}

	boolean outSideBoard(Position p) {
		if (p.row < 0 || p.col < 0 || p.row >= MAX || p.col >= MAX)
			return true;
		return false;
	}
	
	boolean killQueenByHorseFast(Position queen, Position horse) 
	{
		if(outSideBoard(queen) || outSideBoard(horse) || matrix[horse.row][horse.col]==1)
			return false;
		
		if(queen.Compare(horse))
			return true;
		
		boolean output;
		matrix[horse.row][horse.col] = 1;
	    output = 
	    		killQueenByHorseFast(queen, new Position(horse.row + 2, horse.col + 1)) ||
				killQueenByHorseFast(queen, new Position(horse.row + 2, horse.col - 1)) ||
				killQueenByHorseFast(queen, new Position(horse.row - 2, horse.col + 1)) ||
				killQueenByHorseFast(queen, new Position(horse.row - 2, horse.col - 1)) ||
				killQueenByHorseFast(queen, new Position(horse.row + 1, horse.col + 2)) ||
				killQueenByHorseFast(queen, new Position(horse.row + 1, horse.col - 2)) ||
				killQueenByHorseFast(queen, new Position(horse.row - 1, horse.col + 2)) ||
				killQueenByHorseFast(queen, new Position(horse.row - 1, horse.col - 2));
	    matrix[horse.row][horse.col] = 0;
		return output;
	}
}

class Position {
	int row;
	int col;

	Position(int i, int j) {
		row = i;
		col = j;
	}

	public boolean Compare(Position p) {
		if (this.row == p.row && this.col == p.col)
			return true;
		return false;
	}
}
