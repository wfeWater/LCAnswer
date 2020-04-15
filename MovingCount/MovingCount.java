public class MovingCount {
	public static int movingCount(int m, int n, int k) {
		int[][] visited = new int[m][n];
		return dfs(0, 0, m, n, visited, k); 
	}
	private static int dfs(int i, int j, int m, int n, int[][] visited, int k) {
		if (add(i, j) > k || i > m-1 || j > n-1 || visited[i][j] == 1) {
			return 0;
		}
		visited[i][j] = 1;
		return 1 + dfs(i+1, j, m, n, visited, k) + dfs(i, j+1, m, n, visited, k);
	}
	private static int add(int i, int j) {
		int sum = 0;
		while (i!=0) {
			sum += i%10;
			i /= 10;
		}
		while (j!=0) {
			sum += j%10;
			j /= 10;
		}
		return sum;
	}
	public static void main(String[] args) {
		int m = 2, n = 3, k = 1;
		System.out.println(movingCount(m, n, k));
	}
}