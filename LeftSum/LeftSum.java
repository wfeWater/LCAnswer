class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class LeftSum {
	static int sum = 0;
	public static int leftLeafSum(TreeNode root) {
		if (root != null) {
			if (root.left != null && (root.left.left == null && root.left.right == null)) {
				sum += root.left.val;
			}
			leftLeafSum(root.left);
			leftLeafSum(root.right);
		}
		return sum;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode leftFirst = new TreeNode(9);
		TreeNode rightFirst = new TreeNode(20);
		TreeNode leftSecond = new TreeNode(15);
		TreeNode rightSecond = new TreeNode(7);
		root.left = leftFirst;
		root.right = rightFirst;
		leftFirst.left = null;
		leftFirst.right = null;
		rightFirst.left = leftSecond;
		rightFirst.right = rightSecond;
		leftSecond.left = null;
		leftSecond.right = null;
		rightSecond.left = null;
		rightSecond.right = null;
		
		System.out.print(leftLeafSum(root));
	}
}