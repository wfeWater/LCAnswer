class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class RmListEle {
	public static ListNode removeListElement(ListNode head, int target) {
		ListNode dummy = new ListNode(-10);
		dummy.next = head;
		ListNode iter = dummy;
		while (iter.next != null) {
			if (iter.next.val == target) {
				iter.next = iter.next.next;
			}else {
				iter = iter.next;
			}
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(6);
		ListNode forth = new ListNode(3);
		ListNode fifth = new ListNode(4);
		ListNode sixth = new ListNode(5);
		ListNode seventh = new ListNode(6);
		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = sixth;
		sixth.next = seventh;
		seventh.next = null;
		ListNode res = removeListElement(first, 6);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}
}