public class CheckSudoku {

	public static boolean isValidSudoku(int[][] sudoku9X9) {

		if (sudoku9X9 == null || sudoku9X9.length != 9
				|| sudoku9X9[0].length != 9)
			return false;
		// Checking each Row by row

		for (int j = 0; j < 9; j++) {
			boolean[] visited = new boolean[10];
			for (int i = 0; i < 9; i++) {
				if (sudoku9X9[i][j] != -1) {
					if (visited[(sudoku9X9[i][j])]) {
						return false;
					}
					visited[(sudoku9X9[i][j])] = true;
				}
			}
		}

		// Checking Column by column
		for (int i = 0; i < 9; i++) {
			boolean[] visited = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if (sudoku9X9[i][j] != -1) {
					if (visited[(sudoku9X9[i][j])]) {
						return false;
					}
					visited[(sudoku9X9[i][j])] = true;
				}
			}
		}

		// check each 3*3 Block using BlockHashMap
		for (int block = 0; block < 9; block++) {
			boolean[] blockHashMap = new boolean[10];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (sudoku9X9[i][j] != -1) {
						if (blockHashMap[(sudoku9X9[i][j])]) {
							return false;
						}
						blockHashMap[(sudoku9X9[i][j])] = true;
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {

		int[][] sudokuMatrix = {

		{ 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 },
				{ 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 }

		};

		System.out.println(isValidSudoku(sudokuMatrix));
	}
}
