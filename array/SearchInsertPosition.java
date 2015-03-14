package array;

public class SearchInsertPosition {
	/**
	 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
	 * You may assume no duplicates in the array.
	 * Here are few examples.
	 * [1,3,5,6], 5 ¡ú 2
	 * [1,3,5,6], 2 ¡ú 1
	 * [1,3,5,6], 7 ¡ú 4
	 * [1,3,5,6], 0 ¡ú 0
	 */
	public int searchInsert(int[] A, int target) {
		if(A == null || A.length < 1){
			return 0;
		}
        int i = 0, j = A.length - 1;
        while(i <= j){
        	int m = (i + j) / 2;
        	if(A[m] == target){
        		return m;
        	}else if(A[m] < target){
        		i = m + 1;
        	}else{
        		j = m - 1;
        	}
        }
        return i;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition s = new SearchInsertPosition();
		int[] a = {1,3,5,6};
		System.out.println("search 5:" + s.searchInsert(a, 5));
		System.out.println("search 2:" + s.searchInsert(a, 2));
		System.out.println("search 7:" + s.searchInsert(a, 7));
		System.out.println("search 0:" + s.searchInsert(a, 0));
	}

}
