package array;

public class Search2DMatrix {
	/**
	 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
	 * Integers in each row are sorted from left to right.
	 * The first integer of each row is greater than the last integer of the previous row.
	 * For example,
	 * Consider the following matrix:
	 * [
	 *  [1,   3,  5,  7],
	 *   [10, 11, 16, 20],
	 *   [23, 30, 34, 50]
	 * ]
	 * Given target = 3, return true.
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
			return false;
		}
		int r = matrix.length;
		int c = matrix[0].length;
		int i = 0;
		int j = r * c - 1;
		while(i <= j){
			int m = (i + j) / 2;
			int x = m / c;
			int y = m % c;
			if(matrix[x][y] == target) return true;
			else if(matrix[x][y] < target){
				i = m + 1;
			}else{
				j = m -1;
			}
		}
		return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search2DMatrix s = new Search2DMatrix();
		int[][] a = {{1,   3,  5,  7},
				     {10, 11, 16, 20},
				     {23, 30, 34, 50}};
		System.out.println(s.searchMatrix(a, 1));
		System.out.println(s.searchMatrix(a, 50));
		System.out.println(s.searchMatrix(a, 11));
	}

}
