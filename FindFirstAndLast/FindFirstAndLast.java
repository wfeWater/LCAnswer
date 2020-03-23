public class FindFirstAndLast {
	public static int[] findFirstAndLast(int[] nums, int target) {
		int left = 0, right = nums.length-1, mid = 0;
		int[] res = new int[2];
		res[0] = findLeftRange(nums, target);
		res[1] = findRightRange(nums, target);
		return res;
	}
	public static int findLeftRange(int[] nums, int target) {
		int left = 0, right = nums.length-1, mid = 0;
		while (left <= right) {
			mid = left + (right - left)/2;
			if (target == nums[mid]) {
				if (mid == 0 || nums[mid-1] != target) {
					return mid;
				}else {
					right = mid - 1;
				}
			}else if (target < nums[mid]) {
				right = mid - 1;
			}else {
				left = mid + 1; 
			}
		}
		return -1;
	}
	public static int findRightRange(int[] nums, int target) {
		int left = 0, right = nums.length-1, mid = 0;
		while(left <= right) {
			mid = left + (right - left)/2;
			if (target == nums[mid]) {
				if (mid == nums.length-1 || nums[mid+1] != target) {
					return mid;
				}else {
					left = mid + 1;
				}
			}else if (target < nums[mid]) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] ts = {5, 7, 7, 8, 8, 10};
		int[] rs = findFirstAndLast(ts, 8);
		for (int val : rs) {
			System.out.print(val + " ");
		}
	}
}