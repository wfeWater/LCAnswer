public class FindRepeatNum {
	public static int findRepeatNum(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (i != nums[i]) {
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				}
				int tmp = nums[i];
				nums[i] = nums[tmp];
				nums[tmp] = tmp;
			}
		}
			return -1;
	}
	public static void main(String[] args) {
		int[] test = {2, 3, 1, 0, 2, 5, 3};
		System.out.println(findRepeatNum(test));
	} 
}