class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class BinSeaNearAnce {
	public static TreeNode binSeaNearAnce(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val > p.val && root.val > q.val) {
			return binSeaNearAnce(root.left, p, q);
		}
		if (root.val < p.val && root.val < q.val) {
			return binSeaNearAnce(root.right, p, q);
		}
		return root;
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
		
		TreeNode res = binSeaNearAnce(root, secondLeft, secondRight);
		System.out.println(res.val);
		
	}
}