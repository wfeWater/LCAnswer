class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class MergeKSortedList {
	public static ListNode mergeKNode(ListNode[] head) {
		if (head == null || head.length < 0) {
			return null;
		}
		return mergeNode(head, 0, head.length-1);
	}
	public static ListNode mergeNode(ListNode[] head, int left, int right) {
		if (left == right) {
			return head[left];
		}
		int mid = left + (right - left)/2;
		ListNode l = mergeNode(head, left, mid);
		ListNode r = mergeNode(head, mid+1, right);
		return merge(l, r);
	}
	public static ListNode merge(ListNode first, ListNode second) {
		if (first == null || second == null) {
			return first == null ? second : first;
		}
		if (first.val <= second.val) {
			first.next = merge(first.next, second);
			return first;
		}else {
			second.next = merge(first, second.next);
			return second;
		}
	}
	public static void main(String[] args) {
		ListNode firstZero = new ListNode(1);
		ListNode firstFirst = new ListNode(4);
		ListNode firstSecond = new ListNode(5);
		firstZero.next = firstFirst;
		firstFirst.next = firstSecond;
		firstSecond.next = null;
		
		ListNode secondZero = new ListNode(1);
		ListNode secondFirst = new ListNode(3);
		ListNode secondThird = new ListNode(4);
		secondZero.next = secondFirst;
		secondFirst.next = secondThird;
		secondThird.next = null;
		
		ListNode thirdZero = new ListNode(2);
		ListNode thirdFirst = new ListNode(6);
		thirdZero.next = thirdFirst;
		thirdFirst.next = null;
		
		
		ListNode[] test = {firstZero, secondZero, thirdZero};
		ListNode res = mergeKNode(test);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}
}