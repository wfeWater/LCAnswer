class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class ReverseList {
	public static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode start = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return start;
	}
	public static ListNode reverseListXH(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null, cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
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
	//	ListNode res = reverseList(first);
	//	while (res != null) {
	//		System.out.print(res.val + "->");
	//		res = res.next;
	//	}
		ListNode res = reverseListXH(first);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
		
	}
}