class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class TreeToList {
	private static TreeNode head = null;
	private static TreeNode tail = null;
	
	public static TreeNode convertTree(TreeNode root) {
		visit(root);
		head.right = tail;
		tail.left = head;
		return head;
	}
	public static void visit(TreeNode root) {
		if (root == null) {
			return;
		}
		visit(root.left);
		createList(root);
		visit(root.right);
	}
	public static void createList(TreeNode cur) {
		cur.left = tail;
		if (tail != null) {
			tail.right = cur;
		}else {
			head = cur;
		}
		tail = cur;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode firstLeft = new TreeNode(6);
		TreeNode firstRight = new TreeNode(14);
		TreeNode secondLeft = new TreeNode(4);
		TreeNode secondRight = new TreeNode(8);
		TreeNode secondLeftLeft = new TreeNode(12);
		TreeNode secondRightRight = new TreeNode(16);
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
		
		TreeNode res = convertTree(root);
		TreeNode newTail = null;
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.right;
		}
	}
}