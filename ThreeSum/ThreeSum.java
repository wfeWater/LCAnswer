import java.util.*;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return res;
		}
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1, right = nums.length-1;
			if (nums[i] > 0) {
				break;
			}
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while (left < right && nums[left+1] == nums[left]) {
						left++;
					}
					while (left < right && nums[right-1] == nums[right]) {
						right--;
					}
					left++;
					right--;
				}else if(sum < 0) {
					left++;
				}else if (sum > 0) {
					right--;
				}
			}			
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> array = threeSum(nums);
		System.out.println(array);
	}
}