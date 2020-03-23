class Queue {
	private int front;
	private int last;
	private int[] data;
	private int size;
	
	Queue(int capacity) throws Exception{
		if (capacity <= 0) {
			throw new Exception("Size must over zero");
		}else {
			data = new int[capacity];
			size = 0;
			front = 0;
			last = 0;
		}
	}
	
	public void enQueue(int item) throws Exception{
		if (size == data.length) {
			throw new Exception("Array is Full");
		}else {
			data[last] = item;
			size++;
			last = (last + 1) % data.length;
		}
	}
	
	public int deQueue() throws Exception{
		if (size == 0) {
			throw new Exception("Array is Empty");
		}else {
			int res = data[front];
			size--;
			front = (front + 1) % data.length;
			return res;
		}
	}
}

public class QueueByArray {
	public static void main(String[] args) throws Exception{
		Queue q = new Queue(100);
		for (int i = 0; i < 10; i++) {
			q.enQueue(i);
		}
		for (int j = 0; j < 10; j++) {
			System.out.print(q.deQueue() + " ");
		}
	}
}