public class Sqrt {
	public static int sqrt(int x) {
		int left = 0, right = x;
		while (left <= right) {
			long mid = left + (right - left)/2;
			if (mid * mid == x) {
				return (int)mid;
			}else if (mid * mid < x) {
				left = (int)(mid+1); 
			}else {
				right = (int)(mid-1);
			}
		}
		return (int)right;
	}
	public static void main(String[] args) {
		System.out.print(sqrt(2));
	}
}