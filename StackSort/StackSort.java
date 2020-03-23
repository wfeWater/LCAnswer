import java.util.*;

public class StackSort {
	public static Stack<Integer> stackSort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<>();
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!r.isEmpty() && tmp < r.peek()) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
	public static void main(String[] args) {
		Stack<Integer> testS = new Stack<>();
		testS.push(7);
		testS.push(9);
		testS.push(3);
		testS.push(1);
		testS.push(5);
		Stack<Integer> res = stackSort(testS);
		while (!res.isEmpty()) {
			System.out.print(res.pop() + " ");
		}
	}
}