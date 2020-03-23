class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class NearComAnce {
	public static TreeNode getNearCommonAnce(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = getNearCommonAnce(root.left, p, q);
		if (left != null && left != p && left != q) {
			return left;
		}
		TreeNode right = getNearCommonAnce(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}else {
			return left == null ? right : left;
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode firstLeft = new TreeNode(5);
		TreeNode firstRight = new TreeNode(1);
		TreeNode secondLeft = new TreeNode(6);
		TreeNode secondRight = new TreeNode(2);
		TreeNode secondLeftLeft = new TreeNode(0);
		TreeNode secondRightRight = new TreeNode(8);
		
		root.left = firstLeft;
		root.right = firstRight;
		firstLeft.left = secondLeft;
		firstLeft.right = secondRight;
		firstRight.left = secondLeftLeft;
		firstRight.right = secondRightRight;
		secondLeftLeft.left = null;
		secondLeftLeft.right = null;
		secondRightRight.left = null;
		secondRightRight.right = null;
		
		TreeNode res = getNearCommonAnce(root, firstLeft, firstRight);
		System.out.print(res.val);
	}
}