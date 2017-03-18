package sudoku;

import java.util.concurrent.Callable;

public class SudokuRowTask implements Callable<Boolean> {
	private int rowIndex;
	private Sudoku s;
	
	public SudokuRowTask(int rowIndex, Sudoku s) {
		// TODO Auto-generated constructor stub
		this.rowIndex = rowIndex;
		this.s = s;
	}

	
	
	@Override
	public Boolean call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
