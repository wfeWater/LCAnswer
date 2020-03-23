public class ThreeMaxMul {
	public static int maxMul(int[] nums) {
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		
		for (int val : nums) {
			if (val >= max1) {
				max3 = max2;
				max2 = max1;
				max1 = val;
			}else if(val >= max2) {
				max3 = max2;
				max2 = val;
			}else if(val >= max3) {
				max3 = val;
			}
			
			if (val <= min1) {
				min2 = min1;
				min1 = val;
			}else if(val <= min2) {
				min2 = val;
			}
		}
		
		return Math.max(min1*min2*max1, max1*max2*max3);
	}
	public static void main(String[] args) {
		int[] testFirst = {1, 2, 3};
		int[] testSecond = {1, 2, 3, 4};
		System.out.println(maxMul(testFirst));
		System.out.println(maxMul(testSecond));	
	}
}