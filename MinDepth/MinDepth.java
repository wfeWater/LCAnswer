class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class MinDepth {
	public static int minLeafDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int m1 = minLeafDepth(root.left);
		int m2 = minLeafDepth(root.right);
		return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1, m2)+1;		
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode firstLeft = new TreeNode(9);
		TreeNode firstRight = new TreeNode(20);
		TreeNode secondLeft = new TreeNode(15);
		TreeNode secondRight = new TreeNode(7);
		root.left = firstLeft;
		root.right = firstRight;
		firstLeft.left = null;
		firstLeft.right = null;
		firstRight.left = secondLeft;
		firstRight.right = secondRight;
		secondLeft.left = null;
		secondLeft.right = null;
		secondRight.left = null;
		secondRight.right = null;
		
		System.out.print(minLeafDepth(root));
	}
}