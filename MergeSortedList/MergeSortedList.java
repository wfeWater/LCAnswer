public class MergeSortedList {
	public static mergeSortedList(int[] num1, int m, int[] num2, int n) {
		int p1 = m-1;
		int p2 = n-1;
		int p = p1 + p2 - 1;
		
		while (p1 >= 0 && p2 >= 0) {
			num1[p--] = (num1[p1] < num2[p2] ? num2[p2--] : num1[p1--]);
		}
		System.arrayCopy(num2, 0, num1, 0, p2+1);
	}
}