import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class SameTree {
	public static boolean isSameTree(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		}
		return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
	}
	public static boolean isSameTreeByQueue(TreeNode root1, TreeNode root2) {
		if (!check(root1, root2)) {
			return false;
		}
		ArrayDeque<TreeNode> queueFirst = new ArrayDeque<>();
		ArrayDeque<TreeNode> queueSecond = new ArrayDeque<>();
		queueFirst.addLast(root1);
		queueSecond.addLast(root2);
		
		while (!queueFirst.isEmpty()) {
			TreeNode tmpFirst = queueFirst.removeFirst();
			TreeNode tmpSecond = queueSecond.removeFirst();
			if (!check(tmpFirst, tmpSecond)) {
				return false;
			}
			if (tmpFirst != null) {
				if (!check(tmpFirst.left, tmpSecond.left)) {
					return false;
				}
				if (tmpFirst.left != null) {
					queueFirst.addLast(tmpFirst.left);
					queueSecond.addLast(tmpSecond.left);
				}
				if (!check(tmpFirst.right, tmpSecond.right)) {
					return false;
				}
				if (tmpFirst.right != null) {
					queueFirst.addLast(tmpFirst.right);
					queueSecond.addLast(tmpSecond.right);
				}
			}
		}
		return true;
	}
	public static boolean check(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(1);
		TreeNode root1_left = new TreeNode(2);
		TreeNode root1_right = new TreeNode(3);
		TreeNode root2_left = new TreeNode(2);
		TreeNode root2_right = new TreeNode(3);
		root1.left = root1_left;
		root1.right = root1_right;
		root2.left = root2_left;
		root2.right = root2_right;
		root1_left.left = null;
		root1_left.right = null;
		root1_right.left = null;
		root1_right.right = null;
		root2_left.left = null;
		root2_left.right = null;
		root2_left.left = null;
		root2_right.right = null;
		System.out.println("res=" + isSameTree(root1, root2));
		TreeNode rootFirst = new TreeNode(1);
		TreeNode first_left = new TreeNode(2);
		rootFirst.left = first_left;
		first_left.left = null;
		first_left.right = null;
		TreeNode rootSecond = new TreeNode(1);
		TreeNode second_right = new TreeNode(2);
		rootSecond.right = second_right;
		second_right.left = null;
		second_right.right = null;
		System.out.println("res=" + isSameTree(rootFirst, rootSecond));
		System.out.println("res=" + isSameTreeByQueue(root1, root2));
		System.out.println("res=" + isSameTreeByQueue(rootFirst, rootSecond));

	}
}