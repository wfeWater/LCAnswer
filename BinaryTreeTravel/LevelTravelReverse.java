import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class LevelTravelReverse {
	public static List<List<Integer>> levelTravelRev(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		LinkedList<List<Integer>> res = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			LinkedList<Integer> inner = new LinkedList<>();
			int len = q.size();
			for (int i = 0; i < len; i++) {
				TreeNode tmp = q.remove();
				inner.add(tmp.val);
				if (tmp.left != null) {
					q.add(tmp.left);
				}
				if (tmp.right != null) {
					q.add(tmp.right);
				}
			}
			res.addFirst(inner);
		}
		return res;
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
		
		System.out.println(levelTravelRev(root));
	}
}