class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class RotateListNode {
	public static ListNode rotateListNode(ListNode head,int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head;
		int i = 0;
		for (i = 1; pre.next != null; i++) {
			pre = pre.next;
		}
		pre.next = head;
		
		ListNode new_tail = head;
		for (int j = 0; j < i-k%i-1; j++) {
			new_tail = new_tail.next;
		}
		ListNode new_Head = new_tail.next;
		new_tail.next = null;
		return new_Head;
	}
	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode forth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = null;
		ListNode res = rotateListNode(first, 2);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}
}