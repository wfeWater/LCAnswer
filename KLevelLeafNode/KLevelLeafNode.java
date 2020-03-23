class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class KLevelLeafNode {
	public static int kLevelLeafNode(TreeNode root, int level) {
		if (root == null || level <= 0) {
			return 0;
		}
		if (root != null && level == 1) {
			if (root.left == null && root.right == null) {
				return 1;
			}else {
				return 0;
			}
		}
		return kLevelLeafNode(root.left, level-1) + kLevelLeafNode(root.right, level-1);
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
		
		System.out.println(kLevelLeafNode(root, 3));
	}
}