import java.util.*;
public class PostOrderTravel {
	public static List<Integer> postOrderTravel(TreeNode root) {
		LinkedList<TreeNode> q = new LinkedList<>();
		LinkedList<Integer> res = new LinkedList<>();
		q.add(root);
		
		while (!q.isEmpty()) {
			TreeNode tmp = q.removeLast();
			res.addFirst(tmp.val);
			if (tmp.left != null) {
				q.add(tmp.left);
			}
			if (tmp.right != null) {
				q.add(tmp.right);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		List<Integer> output = new LinkedList<>();
		TreeNode root = new TreeNode(10);
		TreeNode firstLeft = new TreeNode(7);
		TreeNode firstRight = new TreeNode(19);
		root.left = firstLeft;
		root.right = firstRight;
		TreeNode secondLeft = new TreeNode(6);
		TreeNode secondRight = new TreeNode(8);
		firstLeft.left = secondLeft;
		firstLeft.right = secondRight;
		
		output = postOrderTravel(root);
		for (int val : output) {
			System.out.print(val + " ");
		}
	}
}