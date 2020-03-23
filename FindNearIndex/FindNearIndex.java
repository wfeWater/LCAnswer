public class FindNearIndex {
	public static int findIndex(int[] nums, int target) {
		int i = 0, j = nums.length-1;
		if (target >= nums[j]) {
			return j;
		}
		if (target <= nums[i]) {
			return i;
		}
		while (i <= j) {
			int mid = i + (j - i)/2;
			if (nums[mid] == target) {
				return mid;
			}else if (nums[mid] > target) {
				j = mid - 1;
			}else {
				i = mid + 1;
			}
		}
		if (i-1 < 0) {
			return i;
		}
		if (Math.abs(nums[i]-target) < Math.abs(nums[i-1]-target)) {
			return i;
		}else {
			return i-1;
		}
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 6, 7, 8};
		System.out.println(findIndex(nums, 4));
	}
}