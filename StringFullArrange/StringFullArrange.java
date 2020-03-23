public class StringFullArrange {
	public static void permutation(String input) {
		if (input == null || input.length() <= 0) {
			return;
		}
		permutation(input.toCharArray(), 0);
	}
	public static void permutation(char[] input, int position) {
		if (input.length-1 == position) {
			System.out.println(input);
		}
		for (int i = position; i < input.length; i++) {
			char tmp = input[i];
			input[i] = input[position];
			input[position] = tmp;
			permutation(input, position+1);
			tmp = input[i];
			input[i] = input[position];
			input[position] = tmp;
		}
	}
	public static void main(String[] args) {
		String test = "abcd";
		permutation(test);
	}
}