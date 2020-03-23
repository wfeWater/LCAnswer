import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class PrintOutNode {
	private static List<TreeNode> res = new LinkedList<>();
	public static void printLeftNode(TreeNode root) {
		TreeNode tmp = root;
		while (tmp != null) {			
			res.add(tmp);
			tmp = tmp.left;
		}
	}
	public static void printLeafNode(TreeNode root) {
		TreeNode tmp = root;
		if (root == null) {
			return;
		}
		if (tmp != null) {
			printLeafNode(root.left);
			if (tmp.left == null && tmp.right == null) {
				if (res.get(res.size()-1) != tmp) {
					res.add(tmp);
				}
				return;
			}
			printLeafNode(root.right);
		}
	}
	
	public static void printRightNode(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode tmp = root;
		tmp = tmp.right;
		while (tmp != null) {
			s.push(tmp);
			tmp = tmp.right;
		}
		while (!s.isEmpty()) {
			TreeNode t = s.pop();
			if (res.get(res.size()-1) != t) {
				res.add(t);
			}
		}
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
		
		printLeftNode(root);
		printLeafNode(root);
		printRightNode(root);
		for(TreeNode t : res) {
			System.out.print(t.val + "->");
		}
	}
}