public class LongestIncreaseLen {
	public static int longestLen(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int count = 1, ans = 1;
		for (int i = 0; i < nums.length-1; i++) {
			if (nums[i+1] > nums[i]) {
				count++;
			}else {
				count = 1;
			}
			ans = Math.max(ans, count);
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] test = {1, 3, 5, 4, 7};
		System.out.println(longestLen(test));
	}
}