import java.lang.Exception;

class Stack {
	private int[] nums;
	private int topFirst;
	private int topSecond;
	private int len;
	
	Stack(int capacity) {
		nums = new int[capacity];
		len = capacity;
		topFirst = 0;
		topSecond = len-1;
	}
	
	public void pushOne(int item) throws Exception{
		if (topFirst+1 == topSecond) {
			throw new Exception("Out of Bounds");
		}else {
			nums[topFirst++] = item; 
		}
	}
	public void pushTwo(int item) throws Exception{
		if (topSecond-1 == topFirst) {
			throw new Exception("Out of Bounds");
		}else {
			nums[topSecond--] = item;
		}
	}
	public int popOne() throws Exception{
		if (topFirst == 0) {
			throw new Exception("No element");
		}else {
			return nums[topFirst--];
		}
	}
	public int popTwo() throws Exception{
		if (topSecond == len-1) {
			throw new Exception("No element");
		}else {
			return nums[topSecond++];
		}
	}
	public void travelStackOne() throws Exception{
		if (topFirst == -1) {
			throw new Exception("Empty");
		}
		for (int i = 0; i < topFirst; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
	public void travelStackTwo() throws Exception{
		if (topSecond == len-1) {
			throw new Exception("Empty");
		}
		for (int i = len-1; i > topSecond; i--) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}

public class ArrayTwoStack {
	public static void main(String[] args) throws Exception{
		Stack s = new Stack(20);
		s.pushOne(1);
		s.pushOne(3);
		s.pushOne(5);
		s.pushTwo(0);
		s.pushTwo(2);
		s.pushTwo(4);
		s.pushTwo(6);
		s.travelStackOne();
		s.travelStackTwo();
		s.popOne();
		s.popTwo();
		s.travelStackOne();
		s.travelStackTwo();
	}
}