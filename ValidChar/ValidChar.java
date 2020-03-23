import java.util.*;

public class ValidChar {
	public static boolean isValidChar(String input) {
		if (input.length() == 0) {
			return true;
		}
		Map<Character, Character> m = new HashMap<>();
		Stack<Character> s = new Stack<>();

		m.put(']', '[');
		m.put('}', '{');
		m.put(')', '(');
		
		for (char item : input.toCharArray()) {
			if (item == '(' || item == '{' || item == '[') {
				s.push(item);
			}
			if ((item == ')' || item == '}' || item == ']') && (s.isEmpty() || s.pop() != m.get(item))) {
				return false;
			} 
		}
		return true;
	}
	public static void main(String[] args) {
		String firstInput = "()";
		String secondInput = "([)]";
		
		System.out.println(isValidChar(firstInput));
		System.out.println(isValidChar(secondInput));
		
	}
}