package dynamicProgramming;

public class UniquePaths {
	/**
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	
	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	
	How many possible unique paths are there?
	
	Note: m and n will be at most 100.
	 */
	public int uniquePaths(int m, int n) {
        if(m < 1 || n < 1) return 0;
        if(m == 1 || n < 1) return 1;
        int[][] paths = new int[m][n];
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(i == 0 || j == 0){
        			paths[i][j] = 1;
        		}else{
        			paths[i][j] = paths[i-1][j] + paths[i][j-1];
        		}
        	}
        }
        return paths[m-1][n-1];
    }
	public int uniquePaths_2(int m, int n) {
        if(m < 1 || n < 1) return 0;
        if(m == 1 || n == 1) return 1;
        int[][] paths = new int[m][n];
        for(int i = 0; i < m; i++){
        	paths[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
        	paths[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		paths[i][j] = paths[i-1][j] + paths[i][j-1];
        	}
        }
        return paths[m-1][n-1];
    }
	/**
	 * Follow up for "Unique Paths":

	Now consider if some obstacles are added to the grids. How many unique paths would there be?
	
	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	
	For example,
	There is one obstacle in the middle of a 3x3 grid as illustrated below.
	
	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]
	The total number of unique paths is 2.
	
	Note: m and n will be at most 100.
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1 || obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for(int i = 0; i < m; i++){
        	if(obstacleGrid[i][0] == 1){
        		while(i < m){
        			obstacleGrid[i++][0] = 0;
        		}
        	}else{
        		obstacleGrid[i][0] = 1;
        	}
        }
        for(int j = 1; j < n; j++){
        	if(obstacleGrid[0][j] == 1){
        		while(j < n){
        			obstacleGrid[0][j++] = 0;
        		}
        	}else{
        		obstacleGrid[0][j] = 1;
        	}
        }
        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		if(obstacleGrid[i][j] == 1){
        			obstacleGrid[i][j] = 0;
        		}else{
        			obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
        		}
        	}
        }
        return obstacleGrid[m-1][n-1];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePaths s = new UniquePaths();
		System.out.println(s.uniquePaths(0, 5));
		System.out.println(s.uniquePaths(3, 1));
		System.out.println(s.uniquePaths(2, 2));
		System.out.println(s.uniquePaths(2, 3));
		System.out.println(s.uniquePaths(3, 4));
		System.out.println(s.uniquePaths(30,30));
		System.out.println(s.uniquePaths(40,40));
		System.out.println(s.uniquePaths(50,50));
		System.out.println("uniquePathsWithObstacles");
		int[][] a = {{0,0,0},
					 {0,1,0},
					 {0,0,0}};
		System.out.println(s.uniquePathsWithObstacles(a));
	}

}
