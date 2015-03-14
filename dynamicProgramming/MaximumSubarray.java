package dynamicProgramming;

public class MaximumSubarray {
	/**
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
	 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
	 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
	 * More practice:
	 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
	 */
	public int maxSubArray(int[] A) {
//        if(A == null || A.length < 1) return 0;
		int maxSum = A[0], sum = 0;
		for(int i = 0; i < A.length; i++){
			sum += A[i];
			if(sum > 0){
				if(maxSum < sum)
					maxSum = sum;
			}else{
				sum = 0;
			}
		}
		return maxSum;
    }
	public int maxSubArray_2(int[] A) {
		int[] a = new int[A.length];
		a[0] = A[0];
		for(int i = 1; i < A.length; i++){
			a[i] = a[i-1] > 0 ? a[i-1] + A[i] : A[i];
		}
		int b = 0;
//		int maxSum = a[a.length -1];
//		for(int i = A.length -1; i > 0; i--){
//			b += A[i];
//			if(b < 0) b = 0;
//			int sum = a[i-1] + b;
//			if(maxSum < sum){
//				maxSum = sum;
//			}
//		}
		int maxSum = a[0];
		for(int i = a.length - 1; i >0; i--){
			if(maxSum < a[i]){
				maxSum = a[i];
			}
		}
		return maxSum;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSubarray s = new MaximumSubarray();
		int[] a = {-2,1,-3,4,-1,2,1,-5,4};
		int[] b = {-1};
		System.out.println(s.maxSubArray(a)+", "+s.maxSubArray_2(a));
		System.out.println(s.maxSubArray(b)+", "+s.maxSubArray_2(b));
	}

}
