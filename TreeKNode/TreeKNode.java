import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class TreeKNode {
	public static TreeNode treeKNode(TreeNode root, int k) {
		if (root == null) {
			return null;
		}
		Stack<TreeNode> s = new Stack<>();
		int count = 0;
		TreeNode res = null;
		
		while (root != null || !s.isEmpty()) {
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			if (!s.isEmpty()) {
				count++;
				root = s.pop();
				if (k == count) {
					res = root;
					break;
				}
				root = root.right;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode firstLeft = new TreeNode(3);
		TreeNode firstRight = new TreeNode(9);
		TreeNode secondLeft = new TreeNode(1);
		TreeNode secondRight = new TreeNode(4);
		TreeNode secondLeftLeft = new TreeNode(8);
		TreeNode secondRightRight = new TreeNode(10);
		
		root.left = firstLeft;
		root.right = firstRight;
		firstLeft.left = secondLeft;
		firstLeft.right = secondRight;
		firstRight.left = secondLeftLeft;
		firstRight.right = secondRightRight;
		
		System.out.println(treeKNode(root, 3).val);
		
	}
}