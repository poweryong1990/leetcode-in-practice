package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	/**
	 * Given a set of distinct integers, S, return all possible subsets.
	
	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If S = [1,2,3], a solution is:
	
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
	 */
	public List<List<Integer>> subsets(int[] S) {
		if(S == null){
			List<List<Integer>> list = new ArrayList<List<Integer>>();
			list.add(new ArrayList<Integer>());
			return list;
		}
		Arrays.sort(S);
        return subsets(S, S.length -1);
    }
	List<List<Integer>> subsets(int[] S, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(new ArrayList<Integer>());
		if(k < 0) return list;
		List<List<Integer>> t = subsets(S, k-1);
		list = copyList(t, S[k]);
		list.addAll(t);
		return list;
	}
	List<List<Integer>> copyList(List<List<Integer>> list, int a){
		List<List<Integer>> ret = new ArrayList<List<Integer>>(list.size());
		for(List<Integer> x: list){
			List<Integer> t = new ArrayList<Integer>();
			for(int y: x){
				t.add(y);
			}
			t.add(a);
			ret.add(t);
		}
		return ret;
	}
	
	void print(List<List<Integer>> list){
		for(List<Integer> row: list){
			System.out.print("[");
			for(int i = 0; i < row.size(); i++){
				if(i == 0){
					System.out.print(row.get(i));
				}else{
					System.out.print(","+row.get(i));
				}
			}
			System.out.print("], ");
		}
		System.out.println();
	}
	/**
	 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
	
	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If S = [1,2,2], a solution is:
	
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]
	 */
	public List<List<Integer>> subsetsWithDup(int[] num) {
		if(num == null || num.length < 1){
			List<List<Integer>> list = new ArrayList<List<Integer>>();
			list.add(new ArrayList<Integer>());
			return list;
		}
		Arrays.sort(num);
        return subsetsWithDup(num, num.length -1);
    }
	List<List<Integer>> subsetsWithDup(int[] num, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(k < 0){
			list.add(new ArrayList<Integer>());
			return list;
		}
		int dup = k;
		while(k > 0 && num[k] == num[k-1]){
			k--;
		}
		dup = dup - k + 1;
		List<List<Integer>> t = subsetsWithDup(num, k-1);
		for(int i = 1; i <= dup; i++){
			list.addAll(copyList(t, num[k], i));
		}
		list.addAll(t);
		return list;
	}
	List<List<Integer>> copyList(List<List<Integer>> list, int a, int times){
		List<List<Integer>> ret = new ArrayList<List<Integer>>(list.size());
		for(List<Integer> x: list){
			List<Integer> t = new ArrayList<Integer>();
			for(int y: x){
				t.add(y);
			}
			for(int i = 0; i < times; i++){
				t.add(a);
			}
			ret.add(t);
		}
		return ret;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets s = new Subsets();
		int[] a = {};
		int[] b = {1};
		int[] c = {1,2,3};
		s.print(s.subsets(a));
		s.print(s.subsets(b));
		s.print(s.subsets(c));
		System.out.println("subsetsWithDup");
		int[] d = {1,2,2};
		s.print(s.subsetsWithDup(d));
	}

}
