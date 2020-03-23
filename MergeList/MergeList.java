class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class MergeList {
	public static ListNode mergeList(ListNode first, ListNode second) {
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		while (first != null && second != null) {
			if (first.val <= second.val) {
				prev.next = first;
				first = first.next;
			}else {
				prev.next = second;
				second = second.next;
			}
			prev = prev.next;			
		}
		prev.next = first == null ? second : first;
		return dummy.next;
	}
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		one.next = two;
		ListNode three = new ListNode (4);
		two.next = three;
		three.next = null;
		
		ListNode One = new ListNode(1);
		ListNode Two = new ListNode(3);
		One.next = Two;
		ListNode Three = new ListNode(4);
		Two.next = Three;
		Three.next = null;
		
		ListNode res = mergeList(one, One);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
		
	}
}