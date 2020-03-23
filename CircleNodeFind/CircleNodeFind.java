class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class CircleNodeFind {
	public static ListNode circleNodeFind(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode fast = head, slow = head;
		while (true) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == null || fast.next == null) {
				return null;
			}
			if (fast == slow) {
				break;
			}
		}
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
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
		ListNode res = circleNodeFind(first);
		System.out.println(res.val);
	}
}