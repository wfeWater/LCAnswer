import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class InorderTravel {
	public static List<Integer> inorderTravel(TreeNode root) {
		if (root == null) {
			return null;
		}
		List<Integer> res = new LinkedList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = root;
		while (!s.isEmpty() || curr != null) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			res.add(curr.val);
			curr = curr.right;
		}
		return res;
	}
	public static List<Integer> inorderTravelDG(TreeNode root) {
		if (root == null) {
			return null;
		}
		List<Integer> res = new LinkedList<>();
		helper(root, res);
		return res;
	}
	public static void helper(TreeNode root, List<Integer> res) {
		if (root != null) {
			if (root.left != null) {
				helper(root.left, res);
			}
			res.add(root.val);
			if (root.right != null) {
				helper(root.right, res);
			}
		}
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
		List<Integer> res = new LinkedList<>();
		res = inorderTravel(root);
		for (int val : res) {
			System.out.print(val + ",");
		}
		System.out.println();
		List<Integer> resDG = new LinkedList<>();
		resDG = inorderTravelDG(root);
		for (int val : resDG) {
			System.out.print(val + ",");
		}
	}
}