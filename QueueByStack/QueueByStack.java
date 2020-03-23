import java.util.*;

class Queue {
	private Stack<Integer> first = new Stack<>();
	private Stack<Integer> second = new Stack<>();
	
	public void enQueue(int item) {
		first.push(item);
	}
	public int deQueue() {
		if (second.isEmpty()) {
			while (!first.isEmpty()) {
				second.push(first.pop());
			}
		}
		return second.pop();
	}
}

public class QueueByStack {
	public static void main(String[] args) {
		Queue q = new Queue();
		for (int i = 0; i < 10; i++) {
			q.enQueue(i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.print(q.deQueue() + " ");
		}
		
	}
}