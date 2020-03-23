public class PalidNum {
	public static boolean isPalidNum(int x) {
		String s = new StringBuilder(x+"").reverse().toString();
		return (x+"").equals(s);
	}
	public static void main(String[] args) {
		int testFirst = 121;
		System.out.println(isPalidNum(testFirst));
		int testSecond = 225;
		System.out.println(isPalidNum(testSecond));
	}
}