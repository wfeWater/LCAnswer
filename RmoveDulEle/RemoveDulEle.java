public class RemoveDulEle {
	public static int rmDulEle(int[] array) {
		//思路：设置快慢指针，如果不同，慢指针+1，快指针覆盖；否则快指针向前，慢指针不动
		if (array.length == 0) {
			return 0;
		}
		int i = 0;
		for(int j = 1; j < array.length; j++) {
			if (array[i] != array[j]) {
				i++;
				array[i] = array[j];
			}
		}
		return i+1;
	}
	public static void main(String[] args) {
		int[] num1 = {1,1,2};
		int[] num2 = {0,0,1,1,2,2,3,3,4};
		System.out.println("First=" + rmDulEle(num1) + " Second=" + rmDulEle(num2));
	} 	
}