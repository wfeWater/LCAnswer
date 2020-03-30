public class TwoDArrayFind {
	public static boolean arrayFind(int[][] nums, int target) {
		int row = nums.length-1, line = 0;
		while (row >= 0 && line < nums[0].length) {
			if (target > nums[row][line]) {
				line++;				
			}else if (target < nums[row][line]) {
				row--;
			}else {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] test = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {18, 21, 23, 26, 30}};
		System.out.println(arrayFind(test, 5));
		System.out.println(arrayFind(test, 20));
		
	}
}