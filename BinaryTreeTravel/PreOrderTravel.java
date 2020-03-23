import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class PreOrderTravel {
	public static List<Integer> preOrderTravel(TreeNode root) {
		LinkedList<TreeNode> q = new LinkedList<>();
		LinkedList<Integer> output = new LinkedList<>();
		q.add(root);
		
		while (!q.isEmpty()) {
			TreeNode tmp = q.removeLast();
			output.add(tmp.val);
			if (tmp.right != null) {
				q.add(tmp.right);
			}
			if (tmp.left != null) {
				q.add(tmp.left);
			}
		}
		return output;
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
		
		List<Integer> res = preOrderTravel(root);
		for (int val : res) {
			System.out.print(val + " ");
		}
	}
}