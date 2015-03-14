package array;

public class RemoveDuplicatesFromSortedArray {
	/**
	 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	 * Do not allocate extra space for another array, you must do this in place with constant memory.
	 * For example,
	 * Given input array A = [1,1,2],
	 * Your function should return length = 2, and A is now [1,2].
	 */
	public int removeDuplicates(int[] A) {
		if(A == null || A.length < 1){
			return 0;
		}
        int i = 0, j = 0;
        while(++j < A.length){
        	if(A[i] != A[j]){
        		A[++i] = A[j];
        	}
        }
        return i + 1;
    }
	/**
	 * Follow up for "Remove Duplicates":
	 * What if duplicates are allowed at most twice?
	 * For example,
	 * Given sorted array A = [1,1,1,2,2,3],
	 * Your function should return length = 5, and A is now [1,1,2,2,3].
	 */
	public int removeDuplicates2(int[] A) {
		if(A == null || A.length < 1){
			return 0;
		}
        int i = 0, j = 0;
        boolean flag = false;
        while(++j < A.length){
        	if(!flag){
        		if(A[i] == A[j]){
        			flag = true;
        		}
        		A[++i] = A[j];
        	}else/* if(flag)*/{
        		if(A[i] != A[j]){
        			flag = false;
        			A[++i] = A[j];
        		}
        	}
        }
        return i + 1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesFromSortedArray s = new RemoveDuplicatesFromSortedArray();
		int[] a = {1,2,3,2,4,5,2,6,2,2,7};
		Array.print(a);
		int j = s.removeDuplicates(a);
		Array.print(a);
		
		int[] b = new int[0];
		System.out.println(b.length);
		int[] c = {};
		System.out.println(c.length);
		System.out.println(s.removeDuplicates(null));
		
		int[] d = {1,1,1,2,2,3};
		j = s.removeDuplicates2(d);
		Array.print(d);
		
		int[] e = {1,2};
		j = s.removeDuplicates2(e);
		Array.print(e);
		
		int[] f = {1,1,1,2,3};
		j = s.removeDuplicates2(f);
		Array.print(f);
		System.out.println();
	}

}
