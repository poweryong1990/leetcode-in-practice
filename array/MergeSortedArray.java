package array;

public class MergeSortedArray {
	/**
	 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
	 * Note:
	 * You may assume that A has enough space (size that is greater or equal to m + n) to hold
	 * additional elements from B. The number of elements initialized in A and B are m and n respectively.
	 */
	public void merge(int A[], int m, int B[], int n) {
        int p = m + n;
        m--;
        n--;
        while(n >= 0){
        	p--;
        	if(m >= 0 && A[m] > B[n]){
        		A[p] = A[m--];
        	}else{
        		A[p] = B[n--];
        	}
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortedArray s = new MergeSortedArray();
		int[] a = {1,2,3,4,5,6,0,0,0,0,0,0};
		int[] b = {2,3,5,6,7,8};
		s.merge(a, 6, b, 6);
		Array.print(a);
	}

}
