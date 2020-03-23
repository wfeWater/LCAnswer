import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}
public class GetPathSum {
	static List<List<Integer>> res = new LinkedList<>();
	static List<Integer> inner = new LinkedList<>();
	
	public static List<List<Integer>> getPathSum(TreeNode root, int target) {
		if (root == null) {
			return res;
		}
		target -= root.val;
		inner.add(root.val);
		if (root.left == null && root.right == null && target == 0) {
			res.add(new ArrayList<>(inner));
		}
		if (root.left != null) {
			getPathSum(root.left, target);
		}
		if (root.right != null) {
			getPathSum(root.right, target);
		}
		inner.remove(inner.size()-1);
		return res;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode firstLeft = new TreeNode(4);
		TreeNode firstRight = new TreeNode(8);
		TreeNode secondLeft = new TreeNode(11);
		TreeNode secondSecondLeft = new TreeNode(13);
		TreeNode secondRight = new TreeNode(4);
		TreeNode thirdLeft = new TreeNode(7);
		TreeNode thirdRight = new TreeNode(2);
		TreeNode thirdRightRight = new TreeNode(1);
		root.left = firstLeft;
		root.right = firstRight;
		firstLeft.left = secondLeft;
		secondLeft.left = thirdLeft;
		secondLeft.right = thirdRight;
		thirdLeft.left = null;
		thirdLeft.right = null;
		thirdRight.left = null;
		thirdRight.right = null;
		firstRight.left = secondSecondLeft;
		firstRight.right = secondRight;
		secondSecondLeft.left = null;
		secondSecondLeft.right = null;
		secondRight.left = null;
		secondRight.right = thirdRightRight;
		thirdRightRight.left = null;
		thirdRightRight.right = null;
		
		System.out.println(getPathSum(root, 22));
	}
}