public class BinarySearchSortedArray {
	public static int binarySearchAnotherVer(int[] nums, int target) {
		if (nums.length == 0 || nums == null) {
			return -1;
		} 
		int left = 0, right = nums.length-1, mid = 0;
		while (left <= right) {
			mid = left + (right - left)/2;
			if (target == nums[mid]) {
				return mid;
			}
			if (nums[mid] >= nums[left]) {
				if (target >= nums[left] && target < nums[mid]) {
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}else {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				}else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int resFir = binarySearchAnotherVer(nums, 0);
		int resSec = binarySearchAnotherVer(nums, 3);
		System.out.println("resFir=" + resFir + " resSec=" + resSec);
	}
}