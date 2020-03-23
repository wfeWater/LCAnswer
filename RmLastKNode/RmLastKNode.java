class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class RmLastKNode {
	//思路：关键是思路。一次遍历需要快慢指针，快指针先走K步，然后快慢一起走直到快指针到尾。
	public static ListNode rmLastKNode(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode fast = head, slow = head;
		while (k > 0) {
			fast = fast.next;
			k--;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}
	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode forth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = sixth;
		sixth.next = null;
		rmLastKNode(first, 2);
		while (first != null) {
			System.out.print(first.val + "->");
			first = first.next;
		}

	}
}