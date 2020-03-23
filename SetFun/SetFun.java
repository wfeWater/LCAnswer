import java.util.*;

public class SetFun {
	public static Integer[] getJ(Integer[] m, Integer[] n) {
		List<Integer> res = new ArrayList<>();
		Set<Integer> longArray = new HashSet<Integer>(Arrays.asList(m.length > n.length ? m : n));
		
		for (Integer val : m.length > n.length ? n : m) {
			if (longArray.contains(val)) {
				res.add(val);	
			}
		}
		Integer[] arr = {};
		return res.toArray(arr);
	}
	public static Integer[] getB(Integer[] m, Integer[] n) {
		Set<Integer> mSet = new HashSet<Integer>(Arrays.asList(m));
		Set<Integer> nSet = new HashSet<Integer>(Arrays.asList(n));
		
		mSet.addAll(nSet);
		Integer[] arr = {};
		return mSet.toArray(arr);
	}
	public static void main(String[] args) {
		Integer[] first = {0,1,3,5,7,9};
		Integer[] second = {0,2,4,6,8};
		
		Integer[] resJ = getJ(first, second);
		Integer[] resB = getB(first, second);
		
		for (int val : resJ) {
			System.out.print(val + " ");
		}
		System.out.println();
		for (int val : resB) {
			System.out.print(val + " ");
		}
	}
}