class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class KGroupReverseList {
	public static ListNode kGroupReverse(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode p = head;
		int tmp = k;
		while (k > 1) {
			if (p == null) {
				break;
			}
			k--;
			p = p.next;
		}
		if (p == null) {
			return head;
		}
		ListNode headNext = p.next, oldHead = head;
		head = reverseList(head, p);
		p = oldHead;
		p.next = kGroupReverse(headNext, k);
		return head;		
	}
	public static ListNode reverseList(ListNode start, ListNode end) {
		ListNode pre = null, cur = start;
		ListNode endNode = end.next;
		while (cur != endNode) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode forth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = null;
		
		
		ListNode resAnoth = kGroupReverse(head, 2);
		while (resAnoth != null) {
			System.out.print(resAnoth.val + "->");
			resAnoth = resAnoth.next;
		}
	}
}