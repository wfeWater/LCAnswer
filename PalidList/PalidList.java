class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class PalidList {
	public static boolean PalidList(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode mid = slow.next;
		slow.next = null;
		ListNode rightReverse = reverse(mid);
		while (rightReverse != null) {
			if (head.val != rightReverse.val) {
				return false;
			}
			head = head.next;
			rightReverse = rightReverse.next;
		}
		return true;
	}
	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null, curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		first.next = second;
		second.next = null;
		boolean resFirst = PalidList(first);
		System.out.println("resF=" + resFirst);
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(2);
		ListNode four = new ListNode(1);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = null;
		boolean resSecond = PalidList(one);
		System.out.println("resS=" + resSecond);
	}
}