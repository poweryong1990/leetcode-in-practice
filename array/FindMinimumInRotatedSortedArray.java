package array;

public class FindMinimumInRotatedSortedArray {
	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * Find the minimum element.
	 * You may assume no duplicate exists in the array.
	 */
	public int findMin(int[] num) {
//		if(num == null || num.length < 1) error
        int n = 0;
        while(n < num.length - 1 && num[n] < num[n+1]) n++;
        if(n < num.length-1)
        	return num[n+1];
        else
        	return num[0];
	}
	//if num[start] < num[end], area between start and end is sorted!
	public int findMin2(int[] num) {
//		if(num == null) System.exit(-1);
		if(num.length == 1) return num[0];
		int i = 0, j = num.length - 1;
		while(i < j){
			if(num[i] < num[j]) return num[i];
			int mid = (i + j) / 2;
			if(num[i] <= num[mid]) i = mid + 1;
			else j = mid;
		}
		return num[i];
	}
	/**
	 * Follow up for "Find Minimum in Rotated Sorted Array":
	 * What if duplicates are allowed?
	 * Would this affect the run-time complexity? How and why?
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * Find the minimum element.
	 * The array may contain duplicates.
	 */
	public int findMinII(int[] num) {
		int n = 0;
        while(n < num.length - 1 && num[n] <= num[n+1]) n++;
        if(n < num.length-1)
        	return num[n+1];
        else
        	return num[0];
    }
	public int findMiddle(int[] num) {
        int n = 0;
        while(n < num.length - 1 && num[n] < num[n+1]) n++;
        n = num.length - n - 1;
        int m = (num.length + 1) / 2;
        if(m > n){
        	return num[m-n-1];
        }else if(m == n){
        	return num[num.length-1];
        }else{
        	return num[num.length -n + m -1];
        }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMinimumInRotatedSortedArray s = new FindMinimumInRotatedSortedArray();
		int[] a = {4,5,6,7,0,1,2};
		System.out.println("middle: " + s.findMiddle(a));
		System.out.println("minimum: " + s.findMin2(a));
	}

}
