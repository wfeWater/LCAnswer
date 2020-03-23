import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class RightSideView {
	private static List<Integer> res = new LinkedList<>();
	public static List<Integer> rightSideView(TreeNode root) {
		if (root != null) {
			helper(root, 0);
		}
		return res;
	}
	public static void helper(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (res.size() == level) {
			res.add(root.val);
		}
		helper(root.right, level+1);
		helper(root.left, level+1);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode firstLeft = new TreeNode(7);
		TreeNode firstRight = new TreeNode(19);
		root.left = firstLeft;
		root.right = firstRight;
		TreeNode secondLeft = new TreeNode(6);
		TreeNode secondRight = new TreeNode(8);
		firstLeft.left = secondLeft;
		firstLeft.right = secondRight;
		
		for (int val : rightSideView(root)) {
			System.out.print(val + " ");
		}
	}
}