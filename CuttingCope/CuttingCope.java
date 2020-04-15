public class CuttingCope {
	public static int cutting(int m) {
		if (m <= 2) {
			return 1;
		}else if (m == 3) {
			return 2;
		}
		int[] dp = new int[m+1];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		int max = 0;
		for (int i = 4; i <= m; i++) {
			max = 0;
			for (int j = 1; j < i; j++) {
				int res = Math.max(j * (i - j), j * dp[i-j]);
				max = Math.max(max, res);
			}
			dp[i] = max;
		}
		return dp[m];
	}
	public static void main(String[] args) {
		System.out.println(cutting(10));
	}
}