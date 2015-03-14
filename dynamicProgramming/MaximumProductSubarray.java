package dynamicProgramming;

public class MaximumProductSubarray {
	/**
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
	
	For example, given the array [2,3,-2,4],
	the contiguous subarray [2,3] has the largest product = 6.
	 */
	public int maxProduct(int[] A) {
		/* A == null || A.length < 1*/
        int p = A[0];
        int max = A[0], min = A[0];
        int tmx;
        for(int i = 1; i < A.length; i++){
        	tmx = max(max * A[i], A[i], min * A[i]);
        	min = min(max * A[i], A[i], min * A[i]);
        	max = tmx;
        	p = max(max, p);
        }
        return p;
    }
	int max(int a, int b){
		return a > b ? a : b;
	}
	int max(int a, int b, int c){
		if(a > b) 
			return a > c ? a : c;
		else
			return b > c ? b : c;
	}
	int min(int a, int b, int c){
		if(a > b)
			return b > c ? c : b;
		else
			return a > c ? c : a;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProductSubarray s = new MaximumProductSubarray();
		int[] a = {2,3,-2,4};
		int[] b = {3,-2,4,5,-1,-1,7};
		int[] c = {-2};
		int[] d = {-2,0,-1};
		int[] e = {2,-5,-2,-4,3};
		System.out.println(s.maxProduct(a));
		System.out.println("4 * 5 * -1 * -1 * 7 = 140->" + s.maxProduct(b));
		System.out.println(s.maxProduct(c));
		System.out.println(s.maxProduct(d));
		System.out.println("-2 * -4 * 3 = 24-> " + s.maxProduct(e));
	}

}
