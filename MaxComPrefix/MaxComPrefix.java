public class MaxComPrefix {
	public static String maxCommonPrefix(String[] input) {
		if (input.length == 0) {
			return "";
		}
		String ans = input[0];
		for (int i = 1; i < input.length; i++) {
			int j = 0;
			for (; j < ans.length() && j < input[i].length(); j++) {
				if (ans.charAt(j) != input[i].charAt(j)) {
					break;
				}
			}
			ans = ans.substring(0, j);
			if ("".equals(ans)) {
				return ans;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String[] inputFirst = {"flower", "flow", "flight"};
		String[] inputSecond = {"dog", "racecar", "car"};
		System.out.println("inputFirst answer=" + maxCommonPrefix(inputFirst));
		System.out.println("inputSecond answer=" + maxCommonPrefix(inputSecond));
	}
	
}