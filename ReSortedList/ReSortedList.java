class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class ReSortedList {
	public static ListNode resortList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode middleNode = findMiddle(head);
		ListNode midNext = middleNode.next;
		middleNode.next = null;
		ListNode newHead = reverseList(midNext);
		ListNode res = merge(head,newHead); 
		return res;
	}
	public static ListNode findMiddle(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = resortList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}
	public static ListNode merge(ListNode left, ListNode right) {
		ListNode leftTmp;
		ListNode rightTmp;
		ListNode head = left;
		while (left.next != null && right != null) {
			leftTmp = left.next;
			rightTmp = right.next;
			left.next = right;
			right.next = leftTmp;
			left = leftTmp;
			right = rightTmp;
		}
		return head;
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
		ListNode res = resortList(first);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}
}