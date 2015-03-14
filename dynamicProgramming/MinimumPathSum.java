package dynamicProgramming;

public class MinimumPathSum {
	/**
	 * Given a m x n grid filled with non-negative numbers, 
	 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     * Note: You can only move either down or right at any point in time.
	 */
	public int minPathSum(int[][] grid) {
        if(grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] minSum = new int[m][n];
        minSum[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
        	minSum[i][0] = minSum[i-1][0] + grid[i][0]; 
        }
        for(int j = 1; j < n; j++){
        	minSum[0][j] = minSum[0][j-1] + grid[0][j];
        }
        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
            	minSum[i][j] = (minSum[i][j-1] < minSum[i-1][j] ? minSum[i][j-1] : minSum[i-1][j]) + grid[i][j];
            } 
        }
        return minSum[m-1][n-1];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
