class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class HasSubTree {
	public static boolean hasSubTree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		} 
		if (s.val == t.val) {
			return isEqual(s, t) || hasSubTree(s.left, t) || hasSubTree(s.right, t);
		}
		return hasSubTree(s.left, t) || hasSubTree(s.right, t);
	}
	public static boolean isEqual(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		if (s.val == t.val) {
			return isEqual(s.left, t.left) && isEqual(s.right, t.right);
		}
		return false;
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
		
		TreeNode rootAnother = new TreeNode(7);
		TreeNode firstLeftAnother = new TreeNode(6);
		TreeNode firstRightAnother = new TreeNode(18);
		rootAnother.left = firstLeftAnother;
		rootAnother.right = firstRightAnother;
		
		System.out.println(hasSubTree(root, rootAnother));
	}
}