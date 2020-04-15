public class FindIn2DArray {
	public static boolean findIn2DArray(int[][] array, int target) {
		int line = 0, row = array.length-1;
		while (line < array[0].length && row >= 0) {
			if (target > array[row][line]) {
				line++;
			}else if (target < array[row][line]) {
				row--;
			}else {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] test = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
		System.out.println(findIn2DArray(test, 5));
		System.out.println(findIn2DArray(test, 20));
	}
}