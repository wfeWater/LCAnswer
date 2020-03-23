public class UpStairs {
	public static int upStairs(int n) {
		int[] res = new int[n+1];
		res[0] = 0;
		res[1] = 1;
		res[2] = 2;
		if (n <= 2) {
			return res[n];
		}
		for (int i = 3; i <= n; i++) {
			res[i] = res[i-1] + res[i-2];
		}
		return res[n];
	}
	public static void main(String[] args) {
		System.out.println(upStairs(5));
	}
}