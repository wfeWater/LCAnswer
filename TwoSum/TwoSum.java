import java.util.*;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int[] index = new int[2];
		Map<Integer, Integer> m = new HashMap<>();	//key为num[i] val为i
		
		for (int i = 0; i < nums.length; i++) {
			int res = target - nums[i];
			if (m.containsKey(res)) {
				index[0] = m.get(res);
				index[1] = i;
				return index;
			}
			m.put(nums[i], i);
		}
		return index;
	}
	public static void main(String[] args) {
		int[] test = {1,3,5,7,9};
		int[] res = twoSum(test, 16);
		for (int val : res) {
			System.out.print(val + "->");
		}
	}
	
}