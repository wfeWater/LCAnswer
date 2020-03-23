import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class SymmetricTree {
	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return false;
		}
		return helper(root, root);
	}
	public static boolean helper(TreeNode first, TreeNode second) {
		if (first == null && second == null) {
			return true;
		}
		if (first == null || second == null) {
			return false;
		}
		if (first.val != second.val) {
			return false;
		}
		return helper(first.left, second.right) && helper(first.right, second.left);
	}
	public static boolean isSymmetricXH(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode q1 = q.poll();
			TreeNode q2 = q.poll();
			
			if (q1 == null && q2 == null) {
				continue;
			}
			if (q1 == null || q2 == null) {
				return false;
			}
			if (q1.val != q2.val) {
				return false;
			}
			q.add(q1.left);
			q.add(q2.right);
			q.add(q1.right);
			q.add(q2.left);
		}
		return true;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode firstLeft = new TreeNode(2);
		TreeNode firstRight = new TreeNode(2);
		TreeNode secondLeft = new TreeNode(3);
		TreeNode secondRight = new TreeNode(4);
		TreeNode secondLeftLeft = new TreeNode(4);
		TreeNode secondRightRight = new TreeNode(3);
		root.left = firstLeft;
		root.right = firstRight;
		firstLeft.left = secondLeft;
		firstLeft.right = secondRight;
		firstRight.left = secondLeftLeft;
		firstRight.right = secondRightRight;
		secondLeft.left = null;
		secondLeft.right = null;
		secondRight.left = null;
		secondRight.right = null;
		secondLeftLeft.left = null;
		secondLeftLeft.right = null;
		secondRightRight.left = null;
		secondRightRight.right = null;
		
		boolean res = isSymmetric(root);
		System.out.println(res);
		boolean resXh = isSymmetricXH(root);
		System.out.print(resXh);
	}
}