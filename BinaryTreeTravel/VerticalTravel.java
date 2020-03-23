import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

class Position {
	TreeNode node;
	int level;
	Position(TreeNode node, int level) {
		this.node = node;
		this.level = level;
	}
}

public class VerticalTravel {
	public static List<List<Integer>> verticalTravel(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		Map<Integer, List<Integer>> m = new HashMap<>();
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(root, 0));
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		while (!q.isEmpty()) {
			int size = q.size();
				Position p = q.remove();
				List<Integer> list = m.get(p.level);
				max = Math.max(max, p.level);
				min = Math.min(min, p.level);
				if (list == null) {
					list = new LinkedList<Integer>();
					m.put(p.level, list);
				}
				list.add(p.node.val);
				if (p.node.left != null) {
					q.add(new Position(p.node.left, p.level-1));
				}
				if (p.node.right != null) {
					q.add(new Position(p.node.right, p.level+1));
				}
		}
		for (int i = min; i <= max; i++) {
			List<Integer> inner = m.get(i);
			if (inner != null) {
				res.add(inner);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode firstLeft = new TreeNode(9);
		TreeNode firstRight = new TreeNode(20);
		TreeNode secondLeft = new TreeNode(15);
		TreeNode secondRight = new TreeNode(7);
		root.left = firstLeft;
		root.right = firstRight;
		firstLeft.left = null;
		firstLeft.right = null;
		firstRight.left = secondLeft;
		firstRight.right = secondRight;
		secondLeft.left = null;
		secondLeft.right = null;
		secondRight.left = null;
		secondRight.right = null;
		
		System.out.print(verticalTravel(root));
	}
}