public class LastWordLength {
	//思路：使用trim去掉某尾空格，lastIndexOf找到最后一个空格，返回空格下一位到末尾的子串长度
	public static int lastWordLen(String input) {
		input = input.trim();
		int start = input.lastIndexOf(' ')+1;
		return input.substring(start).length();
	}
	//思路：不使用trim,先从末尾遍历找到第一个非空格字符。然后找到最后一个空格字符。end-start即可
	public static int lastIndexOfAnotherVersion(String input) {
		int end = input.length()-1;
		while (end >= 0 && input.charAt(end) == ' ') {
			end--;
		}
		int start = end;
		while (start >= 0 && input.charAt(start) != ' ') {
			start--;
		}
		return end-start;
	}
	public static void main(String[] args) {
		System.out.println(lastWordLen("Hello World"));
		System.out.print(lastIndexOfAnotherVersion("Hello World"));
	}
}