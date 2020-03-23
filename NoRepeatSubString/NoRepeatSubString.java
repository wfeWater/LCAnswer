import java.util.*;

public class NoRepeatSubString {
	
	public static int noRepeatString(String input) {
		int ans = 0;
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0, j = 0; j < input.length(); j++ ){
			if (m.containsKey(input.charAt(j))) {
				i = Math.max(i, m.get(input.charAt(j)));
			}
			ans = Math.max(ans, j-i+1);
			m.put(input.charAt(j), j+1);
		}
		return ans;
	}
	public static void main(String[] args) {
		String inputFirst = "abcabcbb";
		String inputSecond = "bbbbb";
		String inputThird = "pwwkew";
		System.out.println(noRepeatString(inputFirst));
		System.out.println(noRepeatString(inputSecond));
		System.out.println(noRepeatString(inputThird));
	}
}