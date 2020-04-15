public class RotateArrayFindMin {
	public static int findMinNoRepeat(int[] nums) {
		int left = 0, right = nums.length-1, mid = 0;
		while (left < right) {
			mid = left + (right - left)/2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		return nums[left];
	}
	public static int findMinRepeat(int[] nums) {
		int left = 0, right = nums.length-1, mid = 0;
		while (left < right) {
			mid = left + (right - left)/2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			}else if (nums[mid] < nums[right]) {
				right = mid;
			}else {
				right--;
			}
		}
		return nums[left];
	}
	public static void main(String[] args) {
		int[] nRTest = {3,4,5,1,2};
		int[] rTest = {2,2,2,0,1};
		System.out.println(findMinNoRepeat(nRTest));
		System.out.println(findMinNoRepeat(rTest));		
	}
}