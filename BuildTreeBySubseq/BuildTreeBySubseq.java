import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class BuildTreeBySubseq {
	public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
		if (preOrder == null || inOrder == null || preOrder.length != inOrder.length || preOrder.length == 0 || inOrder.length == 0) {
			return null;
		}
		return buildTree(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
	}
	public static TreeNode buildTree(int[] preOrder, int pStart, int pEnd, int[] inOrder, int iStart, int iEnd) {
		if (pStart > pEnd || iStart > iEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preOrder[pStart]);
		int index = 0;
		while (preOrder[pStart] != inOrder[iStart + index]) {
			index++;
		}
		root.left = buildTree(preOrder, pStart+1, pStart+index, inOrder, iStart, iStart+index-1);
		root.right = buildTree(preOrder, pStart+index+1, pEnd, inOrder, iStart+index+1, iEnd);
		return root;
	}
	public static List<Integer> inOrderTravel(TreeNode root) {
		List<Integer> res = new LinkedList<>();
		Stack<TreeNode> s = new Stack<>();
		
		
		while (root != null || !s.isEmpty()) {
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			root = s.pop();
			res.add(root.val);
			root = root.right;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] preorder = {3, 9, 20, 15, 7};
		int[] inorder = {9, 3, 15, 20, 7};
		TreeNode root = buildTree(preorder, inorder);
		List<Integer> r = new LinkedList<>();
		r = inOrderTravel(root);
		for (int val : r) {
			System.out.print(val + "->");
		}
	}
}