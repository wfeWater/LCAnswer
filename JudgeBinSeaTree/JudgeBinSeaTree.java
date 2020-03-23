import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class JudgeBinSeaTree {
	public static boolean isBinSeaTree(TreeNode root) {
		if (root == null) {
			return false;
		}
		Stack<TreeNode> s = new Stack<>();
		double inOrder = - Double.MAX_VALUE;
		TreeNode curr = root;
		while (!s.isEmpty() || curr != null) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			if (curr.val <= inOrder) {
				return false;
			}
			inOrder = curr.val;
			curr = curr.right;
		}
		return true;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode firstLeft = new TreeNode(1);
		TreeNode firstRight = new TreeNode(4);
		root.left = firstLeft;
		root.right = firstRight;
		firstLeft.left = null;
		firstRight.left = null;
		firstLeft.right = null;
		firstRight.right = null;
		
		boolean res = isBinSeaTree(root);
		System.out.print(res);
	}
}