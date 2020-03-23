class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}
public class JudgePathSum {
	public static boolean hasPath(TreeNode root, int target) {
		if (root == null) {
			return false;
		}
		target -= root.val;
		if (root.left == null && root.right == null) {
			return (target == 0);
		}
		return hasPath(root.left, target) || hasPath(root.right, target);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode firstLeft = new TreeNode(4);
		TreeNode firstRight = new TreeNode(8);
		TreeNode secondLeft = new TreeNode(11);
		TreeNode secondSecondLeft = new TreeNode(13);
		TreeNode secondRight = new TreeNode(4);
		TreeNode thirdLeft = new TreeNode(7);
		TreeNode thirdRight = new TreeNode(2);
		TreeNode thirdRightRight = new TreeNode(1);
		root.left = firstLeft;
		root.right = firstRight;
		firstLeft.left = secondLeft;
		secondLeft.left = thirdLeft;
		secondLeft.right = thirdRight;
		thirdLeft.left = null;
		thirdLeft.right = null;
		thirdRight.left = null;
		thirdRight.right = null;
		firstRight.left = secondSecondLeft;
		firstRight.right = secondRight;
		secondSecondLeft.left = null;
		secondSecondLeft.right = null;
		secondRight.left = null;
		secondRight.right = thirdRightRight;
		thirdRightRight.left = null;
		thirdRightRight.right = null;
		
		System.out.println(hasPath(root, 222));
		
	}
}