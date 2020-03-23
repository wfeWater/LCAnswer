class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class CircleList {
	public static boolean isCirle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode slow = head, fast = head.next;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (fast == null || fast.next == null) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		ListNode first = new ListNode(3);
		ListNode second = new ListNode(2);
		first.next = second;
		ListNode third = new ListNode(0);
		second.next = third;
		ListNode forth = new ListNode(-4);
		third.next = forth;
		forth.next = second;
		boolean res = isCirle(first);
		System.out.println(res);
	}
}