public class ExchangeOddEven {
	public static int[] exchange(int[] nums) {
		int i = 0, j = nums.length-1;
		while (i != j) {
			while (i != j && (nums[i]&1) == 1) {
				i++;
			}
			while (i != j && (nums[j]&1) == 0) {
				j--;
			}
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
		return nums;
	}
	public static void main(String[] args) {
		int[] num = {1,2,3,4};
		for (int item : exchange(num)) {
			System.out.print(item + " ");
		}
	}
}