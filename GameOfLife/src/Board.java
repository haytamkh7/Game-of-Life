
public class Board {
	int[][] b;

	public Board(int rows, int cols) {
		b = new int[rows][cols];
	}

	// Returns the value stored at specific (row, col) location
	public int get(int row, int col) {
		return b[row][col];
	}

	// Returns the width (number of columns) of the grid
	public int getCols() {
		return b[0].length;
	}

	// Returns the height (number of rows) of the grid
	public int getRows() {
		return b.length;
	}

	// Set specific (row, col) location to specific value
	public void set(int row, int col, int value) {
		b[row][col] = value;
	}

	// Display the grid
	@Override
	public String toString() {
		String result = "";
		for (int r = 0; r < getRows(); r++) {
			for (int c = 0; c < getCols(); c++) {
				result += b[r][c];
			}
			result += "\n";
		}
		return result;
	}
}
