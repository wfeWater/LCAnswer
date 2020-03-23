class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}
public class OddEvenList {
	public static ListNode oddEven(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode odd = head, even = head.next, evenHead = even;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		first.next = second;
		second.next = third;
		third.next = four;
		four.next = five;
		five.next = null;
		
		ListNode rs = oddEven(first);
		while (rs != null) {
			System.out.print(rs.val + "->");
			rs = rs.next; 
		}
	}
}