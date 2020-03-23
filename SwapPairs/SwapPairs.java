class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class SwapPairs {
	public  static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		head.next = swapPairs(next.next);
		next.next = head;
		return next;
	}
	public static ListNode swapPairsXH(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode tmp = pre;
		while (tmp.next != null && tmp.next.next != null) {
			ListNode start = tmp.next;
			ListNode end = tmp.next.next;
			start.next = end.next;
			end.next = start;
			tmp.next = end;
			tmp = start;
		}
		return pre.next;
	}
	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode fout = new ListNode(4);
		first.next = second;
		second.next = three;
		three.next = fout;
		fout.next = null;
		
		//ListNode res = swapPairs(first);
		//while (res != null) {
			//System.out.print(res.val + "->");
			//res = res.next;
		//}
		//System.out.println();
		ListNode resX = swapPairsXH(first);
		while (resX != null) {
			System.out.print(resX.val + "->");
			resX = resX.next;
		}
	}
}