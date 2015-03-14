package array;

import java.util.Stack;

public class MaximalRectangle {
	/**
	 * Given a 2D binary matrix filled with 0's and 1's, 
	 * find the largest rectangle containing all ones and return its area.
	 */
	public int maximalRectangle2(char[][] matrix) {
		if(matrix == null || matrix.length == 0 ||matrix[0].length==0) return 0;
		int maxArea = 0;
		int row = matrix.length;
		int column = matrix[0].length;
		int[][] histogram = new int[row][column];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				if(0 == i){
					histogram[i][j] = matrix[i][j] - '0';
				}else{
					histogram[i][j] = matrix[i][j] == '0' ? 0 : 1 + histogram[i-1][j];
				}
			}
		}
		for(int i = 0; i < row; i++){
			int area = largestRectangleArea(histogram[i]);
			if(maxArea < area) maxArea = area;
		}
		return maxArea;
    }
	private int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        while(i <= height.length){
            if(stack.isEmpty() || i < height.length && height[stack.peek()] <= height[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null) return 0;
		int x1, y1, x2, y2;
		int maxArea = 0;
//		int tmpCount = 0;
		for(int i = 0; i < matrix.length; i++){
			x1 = i;
			for(int j = 0; j < matrix[i].length; j++){
				y1 = j;
				x2 = i;
				while(y1 < matrix[i].length && matrix[i][y1] == '0') y1++;
				if(y1 == matrix[i].length) break;
				y2 = y1;
				while(y2 < matrix[i].length - 1 && matrix[i][y2 + 1] == '1') y2++;
				int area;
				while(y1 <= y2){
					while(x2 +1 < matrix.length && y2 < matrix[x2 + 1].length && fullOne(matrix[x2 + 1], y1, y2)){
						x2 += 1;
					}
					area = (x2 - x1 + 1) * (y2 - y1 + 1);
//					System.out.println("Area "+ ++tmpCount +": "+area+", {("+x1+", "+y1+"), ("+x2+", "+y2+")}");
					if(area > maxArea) maxArea = area;
					y2 -= 1;
				}
				
			}
		}
		return maxArea;
    }
	private boolean fullOne(char[] row, int y1, int y2){
		for(int i = y1; i <= y2; i++){
			if(row[i] == '0') return false;
		}
		return true;
	}
	private boolean fullWithOne(char[][] matrix, int x1, int y1, int x2, int y2){
		for(int i = x1; i <= x2; i++){
			for(int j = y1; j <= y2; j++){
				if(matrix[i][j] == '0')
					return false;
			}
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximalRectangle s = new MaximalRectangle();
		char[][] a = {{'0','1','1','0'},
				      {'1','1','0','1'},
				      {'0','1','1','1'},
				      {'0','1','1','0'}
				      };
		Array.print(a);
		System.out.println("Max Area: " + s.maximalRectangle2(a));
		
		char[][] b = {{'1','0','1','1','0','1'},
					  {'1','1','1','1','1','1'},
					  {'0','1','1','0','1','1'},
					  {'1','1','1','0','1','0'},
					  {'0','1','1','1','1','1'},
					  {'1','1','0','1','1','1'}};
		Array.print(b);
		System.out.println("Max Area: " + s.maximalRectangle2(b));
	}

}
