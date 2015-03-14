package array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	/**
	 * Given numRows, generate the first numRows of Pascal's triangle.
	 * For example, given numRows = 5,
	 * Return
	 * [
	 *      [1],
	 *     [1,1],
	 *    [1,2,1],
	 *   [1,3,3,1],
	 *  [1,4,6,4,1]
	 * ]
	 */
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new ArrayList<List<Integer>>(numRows);
        for(int i = 0; i < numRows; i++){
        	ArrayList a = new ArrayList(i + 1);
        	for(int j = 0; j <= i; j++){
        		if(j == 0 || j == i){
        			a.add(1);
        		}else{
        			List b = r.get(i -1);
        			a.add((int)b.get(j -1) + (int)b.get(j));
        		}
        	}
        	r.add(a);
        }
        return r;
    }
	/**
	 * Given an index k, return the kth row of the Pascal's triangle.
	 * For example, given k = 3,
	 * Return [1,3,3,1].
	 * Note:
	 * Could you optimize your algorithm to use only O(k) extra space?
	 */
	public List<Integer> getRow(int rowIndex) {
        List<Integer> r = new ArrayList<Integer>(rowIndex + 1);
        r.add(1);
        for(int i = 1; i < rowIndex; i++){
//        	r.add(getAij(rowIndex, i));
        	r.add(getCnk(rowIndex, i));
        }
        if(rowIndex > 0)
        	r.add(1);
        return r;
    }
	private int getAij(int i, int j){
		if(j == 0 || j == i){
			return 1;
		}else{
			return getAij(i -1, j -1) + getAij(i -1, j);
		}
	}
	private int getCnk(int n, int k){
		double d = 1;
		for(int i = n - k + 1; i <= n; i++){
			d *= i;
		}
		for(int i = 1; i <= k; i++){
			d /= i;
		}
		return (int)Math.round(d);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangle s = new PascalTriangle();
		List<List<Integer>> r = s.generate(5);
		for(List<Integer> a: r){
			for(int b: a){
				System.out.print(b + ",");
			}
			System.out.println();
		}
		
		System.out.println("row 5: ");
		Array.print(s.getRow(5).toArray());
		
		System.out.println("row 29: ");
		Array.print(s.getRow(29).toArray());
	}

}
