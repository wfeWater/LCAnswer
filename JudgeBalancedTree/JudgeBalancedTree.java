class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class JudgeBalancedTree {
	public static boolean isBalancedTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		return (Math.abs(depth(root.left) - depth(root.right)) <= 1) && isBalancedTree(root.left) && isBalancedTree(root.right);
	}
	public static int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode fRight = new TreeNode(2);
		root.left = null;
		root.right = fRight;
		fRight.right = null;
		TreeNode sLeft = new TreeNode(3);
		fRight.left = sLeft;
		sLeft.left = null;
		sLeft.right = null;
		System.out.print(isBalancedTree(root));
	}
}