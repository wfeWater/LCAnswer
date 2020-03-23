public class MaxSubSum {
	public static int maxSum(int[] nums) {
		int ans = nums[0];
		int sum = 0;
		for (int val : nums) {
			if (sum >= 0) {
				sum += val;
			}else {
				sum = val;
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] num = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSum(num));
		
	}
}