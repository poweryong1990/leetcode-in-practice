package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tools.Tools;

public class Permutations {
	/**
	 * Given a collection of distinct numbers, return all possible permutations.
	
	For example,
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 */
	public List<List<Integer>> permute(int[] num) {
        if(num == null || num.length < 1){
        	List<List<Integer>> list = new ArrayList<List<Integer>>();
        	return list;
        }
        boolean[] available = new boolean[num.length];
        for(int i = available.length - 1; i >= 0; i--){
        	available[i] = true;
        }
        return permute(num, available);
    }
	List<List<Integer>> permute(int[] num, boolean[] available) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i = 0; i < num.length; i++){
			if(available[i]){
				available[i] = false;
				List<List<Integer>> subList = permute(num, available);
				available[i] = true;
				for(List<Integer> x: subList){
					x.add(num[i]);
				}
				list.addAll(subList);
			}
		}
		if(list.isEmpty()){
			list.add(new ArrayList<Integer>());
		}
		return list;
    }
	/**
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	
	For example,
	[1,1,2] have the following unique permutations:
	[1,1,2], [1,2,1], and [2,1,1].
	 */
	public List<List<Integer>> permuteUnique(int[] num) {
		if(num == null || num.length < 1){
        	List<List<Integer>> list = new ArrayList<List<Integer>>();
        	return list;
        }
        boolean[] available = new boolean[num.length];
        for(int i = available.length - 1; i >= 0; i--){
        	available[i] = true;
        }
        Arrays.sort(num);
        return permuteUnique(num, available);
    }
	List<List<Integer>> permuteUnique(int[] num, boolean[] available) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i = 0; i < num.length; i++){
			if(available[i]){
				available[i] = false;
				List<List<Integer>> subList = permuteUnique(num, available);
				available[i] = true;
				for(List<Integer> x: subList){
					x.add(num[i]);
				}
				list.addAll(subList);
				while(i < num.length - 1 && num[i] == num[i+1]) i++;
			}
		}
		if(list.isEmpty()){
			list.add(new ArrayList<Integer>());
		}
		return list;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations s = new Permutations();
		int[] a = {};
		int[] b = {1};
		int[] c = {1,2,3};
		Tools.print(s.permute(a));
		Tools.print(s.permute(b));
		Tools.print(s.permute(c));
		System.out.println("permutateUnique");
		int[] d = {1,1,2};
		Tools.print(s.permuteUnique(d));
	}

}
