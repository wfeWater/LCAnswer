import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class BstToGst {
	public static int sum = 0;
	public static TreeNode bstToGst(TreeNode root) {
		if(root != null) {
			if (root.right != null) {
				bstToGst(root.right);
			}
			root.val += sum;
			sum = root.val;
			if (root.left != null) {
				bstToGst(root.left);
			}
		}
		return root;
	}
	public static List<List<Integer>> levelTravel(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> inner = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = q.remove();
				inner.add(tmp.val);
				if (tmp.left != null) {
					q.add(tmp.left);
				}
				if (tmp.right != null) {
					q.add(tmp.right);
				}
			}
			res.add(inner);
		}
		return res;
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
		
		TreeNode res = bstToGst(root);
		System.out.println(levelTravel(res));
	}
}