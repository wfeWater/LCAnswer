class ListNode{
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}
public class RmSortedDul {
	public static ListNode removeSortedDulEle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode curr = head;
		while (curr != null && curr.next != null) {
			if (curr.next.val == curr.val) {
				curr.next = curr.next.next;
			}else {
				curr = curr.next;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(2);
		first.next = second;
		second.next = third;
		third.next = null;
		
		ListNode res = removeSortedDulEle(first);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
		System.out.println();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(1);
		ListNode three = new ListNode(2);
		ListNode four = new ListNode(3);
		ListNode five = new ListNode(3);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = null;
		ListNode anotherRes = removeSortedDulEle(one);
		while (anotherRes != null) {
			System.out.print(anotherRes.val + "->");
			anotherRes = anotherRes.next;
		}
	}
}