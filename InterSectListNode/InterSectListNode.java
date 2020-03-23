class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class InterSectListNode {
	public static ListNode getIntersectListNode(ListNode first, ListNode second) {
		if (first == null && second == null) {
			return null;
		}
		if (first == null || second == null) {
			return null;
		}
		ListNode pFirst = first, pSecond = second;
		while (pFirst != pSecond) {
			pFirst = pFirst.next;
			pSecond = pSecond.next;
			if (pFirst == null) {
				pFirst = second;
			}
			if (pSecond == null) {
				pSecond = first;
			}
		}
		return pFirst;
	}
	public static void main(String[] args) {
		ListNode firstList = new ListNode(4);
		ListNode secondList = new ListNode(1);
		firstList.next = secondList;
		ListNode thirdList = new ListNode(8);
		secondList.next = thirdList;
		ListNode forthList = new ListNode(4);
		thirdList.next = forthList;
		ListNode fifthList = new ListNode(5);
		forthList.next = fifthList;
		fifthList.next = null;
		
		ListNode oneList = new ListNode(5);
		ListNode twoList = new ListNode(0);
		oneList.next = twoList;
		twoList.next = secondList;
		
		ListNode res = getIntersectListNode(firstList, oneList);
		System.out.println(res.val);
		
	}
}