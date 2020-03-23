public class LongestCommonSubSeq {
	public static int longestCommonSub(String text1, String text2) {
		char[] array1 = text1.toCharArray();
		char[] array2 = text2.toCharArray();
		int[][] dp = new int[text1.length()+1][text2.length()+1];
		
		for (int i = 1; i < text1.length()+1; i++) {
			for (int j = 1; j < text2.length()+1; j++) {
				if (array1[i-1] == array2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[text1.length()][text2.length()];
	}
	public static void main(String[] args) {
		String text1 = "abcde";
		String text2 = "ace";
		System.out.println(longestCommonSub(text1, text2));
	}
}