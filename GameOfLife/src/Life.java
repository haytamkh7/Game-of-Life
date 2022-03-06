
public class Life {
	public Board b;
	public int cols;
	public int rows;
	
	public Life(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		b = new Board(rows, cols);
		initializeBoard();
	}
	
	/**
	 * The initializeBoard function sets up the initial board with a random set of cells
	 */
	public void initializeBoard() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				int rnd = (int) (Math.random() * 3); // Random value in the range [0 - 2] inclusive
				if (rnd == 0) {
					b.set(r, c, 1);
				}
			}
		}
	}
	
	/**
	 * The displayBoard function displays the board in the console
	 * actually this function is not related to the final GUI representation of the board
	 * this function was made for testing the state of the board
	 */
	public void displayBoard() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (b.get(r, c) == 0)
					System.out.print("."); // Dead cell
				else
					System.out.print("•");  // Alive cell
			}
			System.out.println();
		}
	}
	
	/**
	 * The calculateNextGeneration function calculates the next generation of the current board (generation)
	 * so after we run this function, the current board will be updated to it's next generation values
	 * based on the standard rules of Conway's Life
	 */
	
	public void calculateNextGeneration() {
		Board nextB = new Board(rows, cols);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				int neighborCount = countNeighbors(r, c);
				if (b.get(r, c) == 1 && neighborCount < 2)
					nextB.set(r, c, 0); // underpopulation
				else if (b.get(r, c) == 1 && neighborCount < 4)
					nextB.set(r, c, 1); 
				else if (b.get(r, c) == 1 && neighborCount > 3)
					nextB.set(r, c, 0); // overpopulation
				else if (b.get(r, c) == 0 && neighborCount == 3)
					nextB.set(r, c, 1); // reproduction
				else
					nextB.set(r, c, 0);
			}
		}
		transferNextToCurrent(nextB);
	}
	
	/**
	 * The countNeighbors function counts the eight cells around a given cell
	 * making sure not to count the cell itself and any cell that is out of the bounds of the board (grid)
	 * @param row the row of the current cell
	 * @param col the col of the current cell
	 * @return number of alive cells (non-zero neighbors)
	 */
	
	public int countNeighbors(int row, int col) {
		int counter = 0;
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				if (r >= 0 && r < rows && c >= 0 && c < cols && !(r == row && c == col) && b.get(r, c) == 1)
					counter++;
			}
		}
		return counter;
	}

	
	/**
	 * The getBoard function returns the current board
	 * @return current board
	 */
	public Board getBoard() {
		return b;
	}

	
	/**
	 * The transferNextToCurrent function replaces the current board cells values with the next generation board values.
	 * @param nextBoard
	 */
	public void transferNextToCurrent(Board nextBoard) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				b.set(r, c, nextBoard.get(r, c));
			}
		}

	}
}
