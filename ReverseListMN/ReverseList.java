class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class ReverseList {
	public static ListNode reverseList(ListNode head, int m, int n) {
		if (head == null) {
			return head;
		}
		ListNode prev = null, cur = head;
		while (m > 1) {
			prev = cur;
			cur = cur.next;
			m--;
			n--;
		}
		ListNode con = prev, tail = cur;
		ListNode tmp = null;
		while (n > 0) {
			tmp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tmp;
			n--;
		}
		if (con != null) {
			con.next = prev;
		}else {
			head = prev;
		}
		tail.next = cur;
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
		ListNode res = reverseList(first, 2, 4);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}
}