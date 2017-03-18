package sudoku;

public class Sudoku {
	private int[][] matrix;

	public Sudoku(int[][] matrix) {
		this.matrix = matrix;
	}

	public int[] getRow(int i) {
		return this.matrix[i];
	}

	public int[] getCol(int i) {
		int[] resultCol = new int[9];

		for (int j = 0; j < 9; j++) {
			resultCol[j] = this.matrix[j][i];
		}
		return resultCol;
	}

	public int[][] getSquare(int i) {
		int[][] resultSquare = new int[3][3];
		int startRow = (i/3) * 3;
		int startCol = (i % 3) * 3;
		
		for(int j = startRow, row = 0; j < startRow+3; row++) {
			for(int k = startCol, col = 0; k < startCol+3; col++) {
				resultSquare[row][col] = this.matrix[j][k];
			}
		}
		
		return resultSquare;
	}
}
