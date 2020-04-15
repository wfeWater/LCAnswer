public class IsNum {
	public static boolean isNum(String s) {
		boolean numFlag = false;
		boolean dotFlag = false;
		boolean eFlag = false;
		char[] input = s.trim().toCharArray();
		for (int i = 0; i < input.length; i++) {
			if (input[i] >= '0' && input[i] <= '9') {
				numFlag = true;
			}else if (input[i] == '.') {
				if (dotFlag || eFlag) {
					return false;
				}
				dotFlag = true;
			}else if (input[i] == 'e' || input[i] == 'E') {
				if (!numFlag || eFlag) {
					return false;
				}
				eFlag = true;
				numFlag = false;
			}else if (input[i] == '-' || input[i] == '+') {
				if (i != 0 && input[i-1] != 'e' && input[i-1] != 'E') {
					return false;
				}
			}else {
				return false;
			}
		}
		return numFlag;
	}
	public static void main(String[] args) {
		String test = "-1E-16";
		System.out.println(isNum(test));
	}
}