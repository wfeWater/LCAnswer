class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class SortList {
	public static ListNode mergeSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head, fast = slow.next;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow.next;
		slow.next = null;
		ListNode left = mergeSortList(head);
		ListNode right = mergeSortList(mid);
		ListNode dummy = new ListNode(0);
		ListNode tmp = dummy;
		while (left != null && right != null) {
			if (left.val < right.val) {
				dummy.next = left;
				left = left.next;
			}else {
				dummy.next = right;
				right = right.next;
			}
			dummy = dummy.next;
		}
		dummy.next = left == null ? right : left;
		return tmp.next;	
		
	}
	public static void main(String[] args) {
		ListNode first = new ListNode(4);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(1);
		ListNode forth = new ListNode(3);
		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = null;
		ListNode res = mergeSortList(first);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}
}