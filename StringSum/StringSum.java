public class StringSum {
	public static String stringSum(String num1, String num2) {
		int i = num1.length()-1, j = num2.length()-1;
		StringBuilder res = new StringBuilder();
		int ca = 0;
		while (i >= 0 || j >= 0) {
			int first = i >= 0 ? num1.charAt(i)-'0' : 0;
			int second = j >= 0 ? num2.charAt(j)-'0' : 0;
			int sum = first + second + ca;
			ca = sum/10;
			res.append(sum%10);
			i--;
			j--;
		}
		if (ca == 1) {
			res.append(ca);
		}
		return res.reverse().toString();
	}
	public static void main(String[] args) {
		String numFirst = "123";
		String numSecond = "323";
		System.out.println(stringSum(numFirst, numSecond));
	}
}