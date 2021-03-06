package GameOfLife;



public class GameOfLife {
	public char matrix[][];
	public int size;
	
	public GameOfLife() {};
	
	public GameOfLife (int size) {
		this.size = size;
		this.matrix = new char[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = '□';
			}
			
		}
	}
	
	
	public void fillSquare(int x, int y) {
		this.matrix[x][y] = '■';
	}
	
	public boolean inRange(int x) {
		return x >=0 && x<size;
	}
	
	public boolean checkForLife(int x, int y) {
		int aliveNeighbours = 0;
		int yMinus = y - 1;
		int yPlus = y + 1;
		int xMinus = x - 1;
		int xPlus = x + 1;
		if (inRange(xMinus) && inRange(yMinus) ) {
			if (matrix[xMinus][yMinus] == '■') {
				aliveNeighbours++;
			}
		}
		if (inRange(xMinus) && inRange(y) ) {
			if (matrix[xMinus][y] == '■') {
				aliveNeighbours++;
			}
		}
		if (inRange(xMinus) && inRange(yPlus) ) {
			if (matrix[xMinus][yPlus] == '■') {
				aliveNeighbours++;
			}
		}
		if (inRange(x) && inRange(yMinus) ) {
			if (matrix[x][yMinus] == '■') {
				aliveNeighbours++;
			}
		}
		if (inRange(x) && inRange(yPlus) ) {
			if (matrix[x][yPlus] == '■') {
				aliveNeighbours++;
			}
		}
		if (inRange(xPlus) && inRange(yMinus) ) {
			if (matrix[xPlus][yMinus] == '■') {
				aliveNeighbours++;
			}
		}
		if (inRange(xPlus) && inRange(y) ) {
			if (matrix[xPlus][y] == '■') {
				aliveNeighbours++;
			}
		}
		if (inRange(xPlus) && inRange(yPlus) ) {
			if (matrix[xPlus][yPlus] == '■') {
				aliveNeighbours++;
			}
		}
		if (matrix[x][y] == '■') {
			if (aliveNeighbours < 2 || aliveNeighbours > 3) {
				return false;
			}
			return true;
		}
		if (matrix[x][y] == '□' && aliveNeighbours == 3) {
			return true;
		}
		return false;
		
		
	}
	
	public void mark() {
		char[][] result = new char[this.size][this.size];
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if(checkForLife(i, j)) {
					result[i][j] = '■';
				}
				else {
					result[i][j] = '□';
				}
			}
		}
		this.matrix = result;
	}
	
	
	
	public String toString() {
		String result = "";
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				result += matrix[i][j] + " ";
			}
			result += "\n";
			
		}
		return result;
	}
	
}
