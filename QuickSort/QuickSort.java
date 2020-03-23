public class QuickSort {
	public static void quickSort(int[] nums, int left, int right) {
		if (nums.length >= 1 || nums != null) {
		int i = left, j = right;
		int tmp = nums[left];

		while (i != j) {
			while (nums[j] >= tmp && i < j) {
				j--;
			}
			while (nums[i] <= tmp && i < j) {
				i++;
			}

			int swap = nums[i];
			nums[i] = nums[j];
			nums[j] = swap;

		}
		nums[left] = nums[i];
		nums[i] = tmp;
		if (i > left)    quickSort(nums, left, j-1);
		if (j < right)    quickSort(nums, j+1, right);		
		}
	}
	public static void main(String[] args) {
		int[] nums = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
		quickSort(nums, 0, nums.length-1);
		for (int val : nums) {
			System.out.print(val + " ");
		}
	}
}