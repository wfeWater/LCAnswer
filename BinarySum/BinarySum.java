public class BinarySum {
	public static String binarySum(String first, String second) {
		int carry = 0;
		StringBuilder res = new StringBuilder();
		int i = first.length()-1, j = second.length()-1;
		while (i >= 0 || j >= 0) {
			int one = i >= 0 ? first.charAt(i)-'0' : 0;
			int two = j >= 0 ? second.charAt(j)-'0' : 0;
			int sum = one + two + carry;
			carry = sum/2;
			res.append(sum%2);
			i--;
			j--;
		}
		if (carry == 1) {
			res.append(carry);
		}
		return res.reverse().toString();
	}
	public static void main(String[] args) {
		System.out.println(binarySum("11", "1"));
	}
}