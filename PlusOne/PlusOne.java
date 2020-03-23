public class PlusOne {
	public static int[] plusOne(int[] digit) {
		//思路：尾数+1，如果%10==0，说明进位，循环继续。否则直接return即可。99这类数字，将原数组长度+1，首位置1即可
		int carry = 0;
		for (int i = digit.length-1; i >=0; i--) {
			digit[i]++;
			digit[i] = digit[i] % 10;
			if (digit[i] != 0) {
				return digit;
			}
		}
		digit = new int[digit.length+1];
		digit[0] = 1;
		return digit;
	}
	public static void main(String[] args) {
		int[] numFir = {1,2,3};
		int[] numSec = {4,3,2,1};
		int[] numThr = {9,9,9,9};
		
		int[] resFir = plusOne(numFir);
		for (int i : resFir) {
			System.out.print(i);
		}
		System.out.println();
		int[] resSec = plusOne(numSec);
		for (int i : resSec) {
			System.out.print(i);
		}
		System.out.println();
		int[] resThr = plusOne(numThr);
		for (int i : resThr) {
			System.out.print(i);			
		}
	}
	
}