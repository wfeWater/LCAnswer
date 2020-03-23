class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class PartitionListNode {
	public static ListNode partListNode(ListNode head, int x) {
		ListNode beforeHead = new ListNode(-1);
		ListNode afterHead = new ListNode(-1);
		ListNode beforeP = beforeHead;
		ListNode afterP = afterHead;
		
		while (head != null) {
			if (head.val < x) {
				beforeP.next = head;
				beforeP = beforeP.next;
			}else {
				afterP.next = head;
				afterP = afterP.next;
			}
			head = head.next;
		}
		afterP.next = null;
		beforeP.next = afterHead.next;
		return beforeHead.next;
	}
	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(4);
		ListNode third = new ListNode(3);
		ListNode forth = new ListNode(2);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(2);
		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = sixth;
		sixth.next = null;
		ListNode res = partListNode(first, 3);
		while(res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
		
	}
}