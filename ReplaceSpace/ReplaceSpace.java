public class ReplaceSpace {
	public static String replaceSpace(String s) {
		StringBuilder res = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c == ' ') {
				res.append("%20");
			}else {
				res.append(c);
			}
		}
		return res.toString();
	}
	public static void main(String[] args) {
		String test = "We are happy";
		System.out.println(replaceSpace(test));
	}
}