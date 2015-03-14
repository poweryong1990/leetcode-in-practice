package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KSum {
	
	/**
	 * Given an array of intergers, find two numbers such that they add up to a specific target number. The
	 * function twoSum should return indices of the two numbers such that they add up to the target,
	 * where index1 must be less than index2 Please note that your returned answers (both index1 and
	 * index2) are not zero-based.
	 * You may assume that each input would have exactly one solution.
	 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
	 */
	public int[] twoSum(int[] numbers, int target) {
		if(numbers == null || numbers.length < 2){
			return null;
		}
		int[] r = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>((int)(numbers.length*1.4));
        for(int i = 0; i < numbers.length; i++){
        	map.put(numbers[i], i);
        	
        }
        for(int i = 0; i < numbers.length; i++){
        	int t = target - numbers[i];
        	if(map.containsKey(t)){
        		t = map.get(t);
        		if(i == t) continue;
        		if(i < t){
        			r[0] = i+1;
        			r[1] = t+1;
        		}else if(i > t){
        			r[0] = t+1;
        			r[1] = i+1;
        		}
        		return r;
        	}
        }
        return r;
    }
	public int[] twoSum2(int[] numbers, int target) {  
	    int[] res = new int[2];  
	    if(numbers==null || numbers.length<2)  
	        return null;  
	    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();  
	    for(int i=0;i<numbers.length;i++)  
	    {  
	        if(map.containsKey(target-numbers[i]))  
	        {  
	            res[0]=map.get(target-numbers[i])+1;  
	            res[1]=i+1;  
	            return res;  
	        }  
	        map.put(numbers[i],i);  
	    }  
	    return null;  
	}  
	/**
	 * @param num is a sorted array.
	 * @param end represents the last index to be considered.
	 * @param target
	 * @return
	 */
	public List<List<Integer>> twoSum(int[] num, int end, int target) {
		List<List<Integer>> r = new ArrayList<List<Integer>>();
		if(num == null || num.length <= end){
			return r;
		}
		int i = 0, j = end;
		while(i < j){
			int sum = num[i] + num[j];
			if(sum == target){
				List<Integer> t = new ArrayList<Integer>();
				t.add(num[i]);
				t.add(num[j]);
				r.add(t);
				i++;
				j--;
			}else if(sum < target){
				i++;
			}else{
				j--;
			}
			while(i < j && i >= 1 && num[i] == num[i-1]) i++;
			while(i < j && j < end && num[j] == num[j+1]) j--;
		}
		return r;
	}
	/**
	 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
	 * Note:
	 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
	 * The solution set must not contain duplicate triplets.
     * For example, given array S = {-1 0 1 2 -1 -4},
     * A solution set is:
     * (-1, 0, 1)
     * (-1, -1, 2)
	 */
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> r = new ArrayList<List<Integer>>(3);
        if(num == null || num.length <= 2){
        	return r;
        }
        Arrays.sort(num);
        for(int i = num.length -1; i >= 1; i--){
        	if(i <= num.length - 2 && num[i] == num[i+1]) continue;
        	List<List<Integer>> t = this.twoSum(num, i-1, -num[i]);
        	for(List<Integer> list: t){
        		list.add(num[i]);
        		r.add(list);
        	}
        }
        return r;
    }
	/**
	 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
     * For example, given array S = {-1 2 1 -4}, and target = 1.
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 */
	public int threeSumClosest(int[] num, int target) {
//        if(num == null || num.length < 3) error
        Arrays.sort(num);
        int minSum = num[0] + num[1] + num[2];
        int minGap = minSum > target ? minSum - target : target - minSum;
        int sum, gap;
        for(int i = 0; i < num.length - 2; i++){
        	int j = i + 1;
        	int k = num.length - 1;
        	while(j < k){
        		sum = num[i] + num[j] + num[k];
        		if(sum == target){
        			return target;
        		}
        		if(sum > target){
        			k--;
        			gap = sum - target;
        		}else{
        			j++;
        			gap = target - sum;
        		}
//        		gap = sum > target ? sum - target : target - sum;
        		if(minGap > gap){
        			minGap = gap;
        			minSum = sum;
        		}        		
        	}
        }
        return minSum;
    }
	/**
	 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
	 * Note:
	 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
	 * The solution set must not contain duplicate quadruplets.
	 *   For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
	 *   A solution set is:
	 *    (-1,  0, 0, 1)
	 *    (-2, -1, 1, 2)
	 *    (-2,  0, 0, 2)
	 */
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> r = new ArrayList<List<Integer>>();
		if(num == null || num.length <= 3){
			return r;
		}
		Arrays.sort(num);
		int endIndex = num.length - 1;
		int sum;// = num[0] + num[1] + num[2] + num[3];
		for(int i =0; i < endIndex - 2; i++){
			if(i > 0 && num[i] == num[i-1]) continue;
			for(int j = i +1; j < endIndex - 1; j++){
				if(j > i + 1 && num[j] == num[j-1]) continue;
				int p = j + 1;
				int q = endIndex;
				while(p < q){
					sum = num[i] + num[j] + num[p] + num[q];
					if(sum == target){
						List<Integer> t = new ArrayList<Integer>(4);
						t.add(num[i]);
						t.add(num[j]);
						t.add(num[p]);
						t.add(num[q]);
						r.add(t);
						p++;
						q--;
					}else if(sum < target){
						p++;
					}else{
						q--;					
					}
					while(p < q && p > j + 1 && num[p] == num[p-1]) p++;
					while(p < q && q < endIndex && num[q] == num[q+1]) q--;
				}				
			}
		}
		return r;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KSum s = new KSum();
		int[] a = {3,2,4};
		int[] r = s.twoSum(a, 6);
		System.out.println(r[0] + ", " + r[1]);
		
		int[] b = {1,2,2,3,3,4,5,6,7,8,8,9};
		Array.print2(s.twoSum(b, b.length -1, 10));
		System.out.println("-----------------------");
		Array.print2(s.twoSum(b, b.length - 3, 10));
		System.out.println("-----------------------");
		int[] c = {1,2,2,3,3,4,6,7,8,8,9};
		Array.print2(s.twoSum(c, c.length -1, 10));
		System.out.println("-----------------------");
		int[] d = {1,2,-2,-1};
		Array.print2(s.threeSum(d));
		
		int[] e = {-1,2,1,-4};
		System.out.println("closest sum = " + s.threeSumClosest(e, 1));
		
		int[] f = {0,2,1,-3};
		System.out.println("closest sum = " + s.threeSumClosest(f, 1));
		
		int[] g = {1, 0, -1, 0, -2, 2};
		Array.print2(s.fourSum(g, 0), ", ", "-->");
		
		int[] h = {-3,-2,-1,0,0,1,2,3};
		Array.print2(s.fourSum(h, 0), ", ", "-->");
		
	}

}
