import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}
public class LevelTravel {
	private static List<List<Integer>> res = new LinkedList<>();
	public static List<List<Integer>> levelTravel(TreeNode root) {
		if (root == null) {
			return res;
		}
		helper(root, 0);
		return res;
	}
	public static void helper(TreeNode root, int level) {
		if (res.size() == level) {
			res.add(new LinkedList<Integer>());
		}
		res.get(level).add(root.val);
		if (root.left != null) {
			helper(root.left, level+1);
		}
		if (root.right != null) {
			helper(root.right, level+1);
		}
	}
	public static List<List<Integer>> levelTravelXH(TreeNode root) {
		List<List<Integer>> resX = new LinkedList<>();
		if (root == null) {
			return resX;
		}
//		int levels = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
//			resX.add(new LinkedList<Integer>());
			LinkedList<Integer> inner = new LinkedList<>();
			int len = q.size();
			for (int i = 0; i < len; i++) {
				TreeNode tmp = q.remove();
//				resX.get(levels).add(tmp.val);
				inner.add(tmp.val);
				if (tmp.left != null) {
					q.add(tmp.left);
				}
				if (tmp.right != null) {
					q.add(tmp.right);
				}
			}
			resX.add(inner);
//			levels++;
		}
		return resX;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode fRight = new TreeNode(2);
		root.left = null;
		root.right = fRight;
		fRight.right = null;
		TreeNode sLeft = new TreeNode(3);
		fRight.left = sLeft;
		sLeft.left = null;
		sLeft.right = null;
		List<List<Integer>> res = levelTravel(root);
		System.out.println(res);
		List<List<Integer>> resX = levelTravelXH(root);
		System.out.println(res);
	}
}