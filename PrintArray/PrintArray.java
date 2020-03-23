public class PrintArray {
	public static void printArray(int x, int y) {
		String[][] res = new String[x][y];
		int index = 0, line = 0;
		int x2 = x, y2 = y;
		int size = x*y;
		int direction = 0; //0:right 1:down 2:left 3:up
		
		for (int i = 0; i < size; i++) {
			if (i < 10) {
				res[index][line] = "0" + i;
			}else {
				res[index][line] = i + "";
			}
			
			if (direction == 0) {
				if (index == x2 - 1) {
					direction++;
				}else {
					index++;
				}				
			}
			
			if (direction == 1) {
				if (line == y2 - 1) {
					direction++;
				}else {
					line++;
				}
			}
			
			if (direction == 2) {
				if (index == x - x2) {
					direction++;
					y2--;
				}else {
					index--;
				}
			}
			
			if (direction == 3) {
				if (line == y - y2) {
					direction = 0;
					x2--;
					index++;
				}else {
					line--;
				}
			}
		}
		
		for (int j = 0; j < y; j++) {
			for (int i = 0; i < x; i++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		printArray(6, 7);
	}
}