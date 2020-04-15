import java.util.*;
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
		HashSet<Character> hs = new HashSet<>();
		for (int i = position; i < input.length; i++) {
			if (hs.contains(input[i])) {
				continue;
			}
			hs.add(input[i]);
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
		String test = "aab";
		permutation(test);
	}
}