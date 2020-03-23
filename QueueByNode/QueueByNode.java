class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}
class Queue {
	private ListNode first;
	private ListNode last;
	private int size;
	
	Queue() {
		first = null;
		last = null;
		size = 0;
	}
	
	public void enQueue(int item) {
		ListNode newNode = new ListNode(item);
		ListNode oldNode = last;
		newNode.next = null;
		last = newNode;
		size++;
		
		if (first == null) {
			first = newNode;
		}else {
			oldNode.next = newNode;
		}
		
	}
	
	public int deQueue() {
		ListNode tmp = first;
		first = first.next;
		size--;
		int resVal = tmp.val;
		tmp = null;
		return resVal;
	}
	public void travel() {
		while (first != null) {
			System.out.print(first.val + "->");
			first = first.next;
		}
	}
}

public class QueueByNode {
	public static void main(String[] args) {
		Queue q = new Queue();
		for (int i = 0; i < 10; i++) {
			q.enQueue(i);
		}
		q.travel();
	}
}