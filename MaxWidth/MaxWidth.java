import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class MaxWidth {
	public static int maxWidth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int res = 1;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		LinkedList<Integer> indexArray = new LinkedList<>();
		indexArray.add(1);
		
		while (!q.isEmpty()) {
			int size = q.size();
			int curIndex = indexArray.remove();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = q.remove();
				if (tmp.left != null) {
					q.add(tmp.left);
					indexArray.add(curIndex*2);
				}
				if (tmp.right != null) {
					q.add(tmp.right);
					indexArray.add(curIndex*2+1);
				}
			}
		}
		if (indexArray.size() >= 2) {
			res = Math.max(res, indexArray.getLast()-indexArray.getFirst()+1);
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
		
		System.out.print(maxWidth(root));
	}
}