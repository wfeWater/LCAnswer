import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}
public class TreeToList {
	public static TreeNode toList(TreeNode root) {
		TreeNode pre = null;
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		
		while (!s.isEmpty()) {
			TreeNode tmp = s.pop();
			if (pre != null) {
				pre.right = tmp;
				pre.left = null;
			}
			if (tmp.right != null) {
				s.push(tmp.right);
			}
			if (tmp.left != null) {
				s.push(tmp.left);
			}
			pre = tmp;
		}
		return root;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode firstLeft = new TreeNode(2);
		TreeNode firstRight = new TreeNode(5);
		TreeNode secondLeft = new TreeNode(3);
		TreeNode secondRight = new TreeNode(4);
		TreeNode secondRightRight = new TreeNode(6);
		root.left = firstLeft;
		root.right = firstRight;
		firstLeft.left = secondLeft;
		firstLeft.right = secondRight;
		firstRight.right = secondRightRight;
		
		TreeNode res = toList(root);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.right;
		}
	}
}