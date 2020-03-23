import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class NonSortedArrayToTree {
	public static TreeNode buildTree(TreeNode root, int i) {
		if (root == null) {
			root = new TreeNode(i);
			return root;
		}else {
			if (root.val >= i) {
				root.left = buildTree(root.left, i);
			}else {
				root.right = buildTree(root.right, i);
			}
		}
		return root;
	}
	public static List<List<Integer>> levelsTravel(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while (!q.isEmpty()) {
			List<Integer> inner = new LinkedList<>();
			int size = q.size();
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
		int[] array = {3, 1, 2, 5, 0, 7, 9, 8,};
		TreeNode root = null;
		for (int i = 0; i < array.length; i++) {
			root = buildTree(root, array[i]);
		}
		List<List<Integer>> res = new LinkedList<>();
		res = levelsTravel(root);
		System.out.print(res);
	}
}