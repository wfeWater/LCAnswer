import java.util.*;
class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class ReversePrintList {
	private static ArrayList<Integer> tmp = new ArrayList<>();
	public static int[] printList(ListNode head) {
		rev(head);
		int[] res = new int[tmp.size()];
		for (int i = 0; i < tmp.size(); i++) {
			res[i] = tmp.get(i);
		}
		return res;
	}
	private static void rev(ListNode head) {
		if (head == null) {
			return;
		}
		rev(head.next);
		tmp.add(head.val);
	}
	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		first.next = second;
		second.next = third;
		third.next = null;
		for (int item : printList(first)) {
			System.out.print(item + " ");
		}
	}
}