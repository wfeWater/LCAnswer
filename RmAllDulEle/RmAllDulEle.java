class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class RmAllDulEle {
	public static ListNode rmAllDulEle(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		while (head != null && head.next != null) {
			if (head.val != head.next.val && head != null && head.next != null) {
				prev = head;
				head = head.next;
			}else {
				while (head.val == head.next.val && head != null && head.next != null) {
					head = head.next;
				}
				prev.next = head.next;
				head = head.next;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode forth = new ListNode(3);
		ListNode fifth = new ListNode(4);
		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = null;
		ListNode res = rmAllDulEle(first);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next; 
		}
	}
}