public class MatrixString {
	public static boolean findString(char[][] matrix, String s) {
		char[] input = s.toCharArray();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (dfs(matrix, input, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	private static boolean dfs(char[][] matrix, char[] array, int i, int j, int k) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] != array[k]) {
			return false;
		} 
		if (k == array.length-1) {
			return true;
		}
		char tmp = matrix[i][j];
		matrix[i][j] = '$';
		boolean res = dfs(matrix, array, i-1, j, k+1) || dfs(matrix, array, i+1, j, k+1) || dfs(matrix, array, i, j-1, k+1) || dfs(matrix, array, i, j+1, k+1);
		matrix[i][j] = tmp;
		return res;
	}
	public static void main(String[] args) {
		char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
		String word = "ABCCED";
		System.out.println(findString(board, word));
	}
}