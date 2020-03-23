class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class TwoPlusListNode {
	public static ListNode twoPlusListNode(ListNode first, ListNode second) {
		if (first == null && second == null) {
			return null;
		}
		ListNode p1 = first;
		ListNode p2 = second;
		ListNode res = new ListNode(-1);
		ListNode head = res;
		int carry = 0;
		while (p1 != null || p2 != null) {
			int iOne = p1 == null ? 0 : p1.val;
			int iTwo = p2 == null ? 0 : p2.val;
			int sum = iOne + iTwo + carry;
			ListNode tmp = new ListNode(sum%10);
			carry = sum/10;
			if (p1 != null) {
				p1 = p1.next;
			}
			if (p2 != null) {
				p2 = p2.next;
			}
			res.next = tmp;
			res = res.next;
		}
		if (carry > 0) {
			res.next = new ListNode(carry);
		}
		return head.next;
	}
	public static void main(String[] args) {
		ListNode headOne = new ListNode(2);
		ListNode headOneN = new ListNode(4);
		ListNode headOneNN = new ListNode(3);
		headOne.next = headOneN;
		headOneN.next = headOneNN;
		headOneNN.next = null;
		
		ListNode headTwo = new ListNode(5);
		ListNode headTwoN = new ListNode(6);
		ListNode headTwoNN = new ListNode(4);
		headTwo.next = headTwoN;
		headTwoN.next = headTwoNN;
		headTwoNN.next = null;
		
		ListNode r = twoPlusListNode(headOne, headTwo);
		while (r != null) {
			System.out.print(r.val + "->");
			r = r.next;
		}
	}
}