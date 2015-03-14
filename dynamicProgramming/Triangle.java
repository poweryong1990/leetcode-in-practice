package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	/**
	 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
	
	For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	
	Note:
	Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty() || triangle.get(0).isEmpty()) return 0;
        int totalRow = triangle.size();
        int[] minSum = new int[totalRow];
        minSum[0] = triangle.get(0).get(0);
//        for(int k = 0; k < totalRow; k++){
//    		System.out.print("->" + minSum[k]);
//    	}
//    	System.out.println();
        for(int i = 1; i < totalRow; i++){
        	List<Integer> row = triangle.get(i);
        	minSum[i] = minSum[i-1] + row.get(i);
        	for(int j = i - 1; j > 0; j--){
        		minSum[j] = (minSum[j-1] < minSum[j] ? minSum[j-1] : minSum[j]) + row.get(j);
        	}
        	minSum[0] = minSum[0] + row.get(0);
//        	for(int k = 0; k < totalRow; k++){
//        		System.out.print("->" + minSum[k]);
//        	}
//        	System.out.println();
        }
        int min = minSum[0];
        for(int i = 1; i < totalRow; i++){
        	if(min > minSum[i])
        		min = minSum[i];
        }
        return min;
    }
	public int minimumTotal_2(List<List<Integer>> triangle) {
		if(triangle == null || triangle.isEmpty() || triangle.get(0).isEmpty()) return 0;
        int totalRow = triangle.size();
        int[] minSum = new int[totalRow];
        List<Integer> row = triangle.get(totalRow -1);
        for(int i = 0; i < totalRow; i++){
        	minSum[i] = row.get(i);
        }
        for(int i = totalRow - 2; i >= 0; i--){
        	row = triangle.get(i);
        	for(int j = 0; j <= i; j++){
        		minSum[j] = row.get(j) + (minSum[j] < minSum[j+1] ? minSum[j] : minSum[j+1]);
        	}
        }
        return minSum[0];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle s = new Triangle();
		List<List<Integer>> a = new ArrayList<List<Integer>>();
		List<Integer> t = new ArrayList<Integer>();
		t.add(2);
		a.add(t);
		t = new ArrayList<Integer>();
		t.add(3);t.add(4);
		a.add(t);
		t = new ArrayList<Integer>();
		t.add(6);t.add(5);t.add(7);
		a.add(t);
		t = new ArrayList<Integer>();
		t.add(4);t.add(1);t.add(8);t.add(3);
		a.add(t);
		System.out.println("Triangle:");
		for(int i = 0; i < a.size(); i++){
			for(int j = 0; j < a.get(i).size(); j++){
				System.out.print("->" + a.get(i).get(j));
			}
			System.out.println();
		}
		System.out.println("minSumPath:");
		System.out.println(s.minimumTotal(a)+", " + s.minimumTotal_2(a));
	}

}
