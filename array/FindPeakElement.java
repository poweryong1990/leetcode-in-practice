package array;

public class FindPeakElement {
	/**
	 * A peak element is an element that is greater than its neighbors.
	 * Given an input array where num[i] ¡Ù num[i+1], find a peak element and return its index.
	 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
	 * You may imagine that num[-1] = num[n] = -¡Þ.
	 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
	 */
	public int findPeakElement(int[] num) {
//		if(num == null || num.length == 0) return -1;
		if(num.length == 1) return 0;
		if(num[0] > num[1]) return 0;
		if(num[num.length - 1] > num[num.length - 2]) return num.length -1;
		for(int i = 1; i < num.length - 1; i++){
			if(num[i -1] < num[i] && num[i] > num[i + 1])
				return i;
		}
		return -1;//here is not reachable
    }
	public int findPeakElement2(int[] num) {
		if(num.length == 1) return 0;
		if(num[0] > num[1]) return 0;
		if(num[num.length - 1] > num[num.length - 2]) return num.length -1;
		int i = 1, j = num.length - 2;
		int m = -1;
		while(i <= j){
			m = (i + j) / 2;
			if(num[m -1] < num[m] && num[m] > num[m +1]) return m;
			else if(num[m - 1] > num[m]){
				j = m - 1;
			}else{
				i = m + 1;
			}
		}
		return m;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPeakElement s = new FindPeakElement();
		int[] a = {5};
		System.out.println("peak: " + s.findPeakElement2(a));
		
		int[] b = {1,2,3,1};
		System.out.println("peak: " + s.findPeakElement2(b));
		
		int[] c = {1,2,1};
		System.out.println("peak: " + s.findPeakElement2(c));
		
		int[] d = {1,2,3,2,1};
		System.out.println("peak: " + s.findPeakElement2(d));
		
		int[] e = {3,4,3,2,1};
		System.out.println("peak: " + s.findPeakElement2(e));
	}

}
