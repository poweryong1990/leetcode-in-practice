package array;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
	/**
	 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
	 * For example,
	 * Given height = [2,1,5,6,2,3],
	 * return 10.
	 */
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
//        int[] h = Arrays.copyOf(height, height.length + 1);
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestRectangleInHistogram s = new LargestRectangleInHistogram();
		int[] a = {2,1,5,6,2,3};
		System.out.println(s.largestRectangleArea(a));
		
		int[] b = {2,1,2,2,3,2,1,5,6,2,3,1};
		System.out.println(s.largestRectangleArea(b));
	}

}
