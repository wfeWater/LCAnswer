import java.util.*;

public class RmKNum {
	public static String rmKNum (String nums,int k) {
		LinkedList<Character> l = new LinkedList<>();
	
		for (Character c : nums.toCharArray()) {
			if (l.size() > 0 && k > 0 && l.peekLast() > c) {
				k--;
				l.removeLast();
			}
			l.addLast(c);
		}
		
		for (int i = 0; i < k; i++) {
			l.removeLast();
		}
		
		StringBuilder res = new StringBuilder();
		boolean leadingZero = true;
		for (char digit : l) {
			if (digit == '0' && leadingZero) {
				continue;
			}
			leadingZero = false;
			res.append(digit);
		}
		if (res.length() == 0) {
			return "0";
		}
		return res.toString();
	}
	public static void main(String[] args) {
		String nums = "1432219";
		System.out.println(rmKNum(nums,3));
		
	}
}