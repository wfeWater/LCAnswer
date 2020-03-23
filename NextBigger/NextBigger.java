import java.util.*;

public class NextBigger {
	public static int[] nextBigger(int[] nums) {
		Stack<Integer> s = new Stack<>();
		s.push(0);
		int index = 1;
		int[] res = new int[nums.length];
		
		while (index < nums.length) {
			if (!s.isEmpty() && nums[s.peek()] < nums[index]) {
				res[s.pop()] = nums[index];
			}else {
				s.push(index++);
			}
		}
		
		while (!s.isEmpty()) {
			res[s.pop()] = -1;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] testA = {1, 5, 3, 6, 4, 8, 9, 10};
		for (int val : nextBigger(testA)) {
			System.out.print(val + " ");
		} 
	}
}