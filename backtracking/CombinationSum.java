package backtracking;
import tree.Tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	/**
	 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

	The same repeated number may be chosen from C unlimited number of times.
	
	Note:
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
	The solution set must not contain duplicate combinations.
	For example, given candidate set 2,3,6,7 and target 7, 
	A solution set is: 
	[7] 
	[2, 2, 3] 
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
        return combinationSum(candidates, candidates.length - 1, target);
    }
	List<List<Integer>> combinationSum(int[] candidates, int n, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(target < candidates[0] || n < 0) return list;
        for(int i = n; i >= 0; i--){
        	int tTarget = target - candidates[i];
        	if(tTarget == 0){
        		List<Integer> a = new ArrayList<Integer>(1);
        		a.add(candidates[i]);
        		list.add(a);
        	}else if(tTarget > 0){
        		List<List<Integer>> a = combinationSum(candidates, i, tTarget); 
        		for(List<Integer> x: a){
        			x.add(candidates[i]);
        		}
        		list.addAll(a);
        	}
        	
        }
        return list;
    }
	/**
	 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
	
	Each number in C may only be used once in the combination.
	
	Note:
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
	The solution set must not contain duplicate combinations.
	For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
	A solution set is: 
	[1, 7] 
	[1, 2, 5] 
	[2, 6] 
	[1, 1, 6] 
	 */
	public List<List<Integer>> combinationSumII(int[] num, int target) {
		Arrays.sort(num);
        return combinationSumII2(num, num.length - 1, target);
    }
	List<List<Integer>> combinationSumII(int[] candidates, int n, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(target < candidates[0] || n < 0) return list;
        for(int i = n; i >= 0; i--){
        	int redundance = i;
        	while(i > 0 && candidates[i] == candidates[i-1]) i--;
        	redundance = redundance - i + 1;
        	for(int j = 1; j <= redundance; j++){
        		int tTarget = target - j * candidates[i];
            	if(tTarget == 0){
            		List<Integer> a = new ArrayList<Integer>(j);
            		for(int k = 0; k < j; k++){
            			a.add(candidates[i]);
            		}
            		
            		list.add(a);
            	}else if(tTarget > 0){
            		List<List<Integer>> a = combinationSumII(candidates, i - 1, tTarget); 
            		for(List<Integer> x: a){
            			for(int k = 0; k < j; k++){
            				x.add(candidates[i]);
            			}
            		}
            		list.addAll(a);
            	}
        	}
        	
        	
        }       
        return list;
    }
	List<List<Integer>> combinationSumII2(int[] candidates, int n, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(target < candidates[0] || n < 0) return list;
        for(int i = n; i >= 0; i--){
        	
    		int tTarget = target - candidates[i];
        	if(tTarget == 0){
        		List<Integer> a = new ArrayList<Integer>(1);
        		a.add(candidates[i]);
        		list.add(a);
        	}else if(tTarget > 0){
        		List<List<Integer>> a = combinationSumII2(candidates, i - 1, tTarget); 
        		for(List<Integer> x: a){
        			x.add(candidates[i]);
        		}
        		list.addAll(a);
        	}
        	while(i > 0 && candidates[i] == candidates[i-1]) i--;
        }       
        return list;
    }
	public static void main(String ... arg){
		CombinationSum s = new CombinationSum();
		int[] a = {2,3,6,7};
		int[] b = {8,7,4,3};
		int[] c = {10,1,2,7,6,1,5};
		int[] d = {4,4,2,1,4,2,2,1,3};
		Tree.print(s.combinationSum(a, 7));
		System.out.println("----------------");
		Tree.print(s.combinationSum(b, 11));
		System.out.println("combinationSumII");
		Tree.print(s.combinationSumII(c, 8));
		System.out.println("-----Sum 6-----------");
		Tree.print(s.combinationSumII(d, 6));
		
	}
}
