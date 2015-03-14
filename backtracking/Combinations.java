package backtracking;
import tree.Tree;
import java.util.ArrayList;
import java.util.List;

public class Combinations {
	/**
	 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	
	For example,
	If n = 4 and k = 2, a solution is:
	
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
	 */
	public List<List<Integer>> combine2(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(n < 1 || k < 1 || n < k) return list;
		if(k == 1){
			for(int i = 1; i <= n; i++){
				List<Integer> com = new ArrayList<Integer>(1);
				com.add(i);
				list.add(com);
			}
		}else if(n == k){
			List<Integer> com = new ArrayList<Integer>(k);
			for(int i = 1; i <= n; i++){
				com.add(i);
			}
			list.add(com);
		}else{
			List<List<Integer>> includeN = combine2(n - 1, k - 1);
			for(int i = 0; i < includeN.size(); i++){
				includeN.get(i).add(n);
			}
			List<List<Integer>> excludeN = combine2(n - 1, k);
			list = includeN;
			list.addAll(excludeN);
		}
		return list;
	}
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(n < 1 || k < 1 || n < k) return list;
		list = combine(1, n, k);
		return list;
    }
	List<List<Integer>> combine(int start, int end, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> com = null;
		if(k == 1){
			for(int i = start; i <= end; i++){
				com = new ArrayList<Integer>(1);
				com.add(i);
				list.add(com);
			}
		}else if(end - start + 1 == k){
			com = new ArrayList<Integer>(k);
			for(int i = start; i <= end; i++){
				com.add(i);
			}
			list.add(com);
		}else if(end - start + 1 > k){
			List<List<Integer>> includeEnd = combine(start, end - 1, k - 1);
			for(int i = 0; i < includeEnd.size(); i++){
				includeEnd.get(i).add(end);
			}
			List<List<Integer>> excludeEnd = combine(start, end - 1, k);
			list = includeEnd;
			list.addAll(excludeEnd);
		}
		return list;
    }
	public static void main(String[] arg){
		Combinations s = new Combinations();
		Tree.print(s.combine2(5, 3));
	}
}
