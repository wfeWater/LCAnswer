import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class ZigzagLevelOrder {
	public static List<List<Integer>> zigzagOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		Queue<TreeNode> q = new LinkedList<>();
		if (root == null) {
			return res;
		}
		q.add(root);
		int flag = 0; 
		
		while (!q.isEmpty()) {
			LinkedList<Integer> inner = new LinkedList<>();
			int len = q.size();
			for (int i = 0; i < len; i++) {
				TreeNode tmp = q.remove();
				if ((flag & 1) == 1) {
					inner.addFirst(tmp.val);
				}else {
					inner.addLast(tmp.val);
				}
				if (tmp.left != null) {
					q.add(tmp.left);
				}
				if (tmp.right != null) {
					q.add(tmp.right);
				}
			}
			res.add(inner);
			flag++;
		}
		return res;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode firstLeft = new TreeNode(2);
		TreeNode firstRight = new TreeNode(3);
		TreeNode secondLeft = new TreeNode(4);
		TreeNode secondRight = new TreeNode(5);
		TreeNode secondLeftLeft = new TreeNode(6);
		TreeNode secondRightRight = new TreeNode(7);
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
		
		List<List<Integer>> res = new LinkedList<>();
		res = zigzagOrder(root);
		System.out.println(res);
		
	}
}