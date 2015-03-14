package array;

public class SearchForARange {
	/**
	 * Given a sorted array of integers, find the starting and ending position of a given target value.
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * If the target is not found in the array, return [-1, -1].
	 * For example,
	 * Given [5, 7, 7, 8, 8, 10] and target value 8,
	 * return [3, 4].
	 */
	public int[] searchRange(int[] A, int target) {
		if(A == null || target < A[0] || A[A.length - 1] < target){
			return new int[] {-1, -1};
		}
		int i = 0, j = A.length - 1;
		while(i <= j && (A[i] != target || A[j] != target)){
			int m = (i + j) / 2;
			if(A[m] == target){
				i = j = m;
				while(i > 0 && A[i - 1] == target) i--;
				while(j < A.length - 1 && A[j + 1] == target) j++;
				return new int[] {i, j};
			}else if(A[m] < target){
				i = m + 1;
			}else{
				j = m - 1;
			}
		}
		if(i <= j){
			return new int[] {i, j};
		}
		return new int[] {-1, -1};
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchForARange s = new SearchForARange();
		int[] a = {0,1,2,3,4,5};
		int target = 3;
		Array.print(s.searchRange(a, target));
		
		int[] b = {0,0,0,1,2,3,4,4,5,5};
		target = 0;
		Array.print(s.searchRange(b, target));
		
		int[] c = {0,0,0,1,2,3,4,4,5,5};
		target = 5;
		Array.print(s.searchRange(c, target));
		
	
	}

}
