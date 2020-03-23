public class NumIsland {
	public static int numsIsland(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}
	public static void dfs(char[][] grid, int i, int j) {
		grid[i][j] = '0';
		if (i-1 >= 0 && grid[i-1][j] == '1') {
			dfs(grid, i-1, j);
		} 
		if (i+1 < grid.length && grid[i+1][j] == '1') {
			dfs(grid, i+1, j);
		}
		if (j+1 < grid[i].length && grid[i][j+1] == '1') {
			dfs(grid, i, j+1);
		}
		if (j-1 >= 0 && grid[i][j-1] == '1') {
			dfs(grid, i, j-1);
		}
	}
	
	
	public static void main(String[] args) {
		char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
		System.out.println(numsIsland(grid));
	}
}