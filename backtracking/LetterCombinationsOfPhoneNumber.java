package backtracking;
import tree.Tree;
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
	/**
	 * Given a digit string, return all possible letter combinations that the number could represent.
	
	A mapping of digit to letters (just like on the telephone buttons) is given below.
	0 -> ""
	1 -> ""
	2 -> "abc"
	3 -> "def"
	4 -> "ghi"
	5 -> "jkl"
	6 -> "mno"
	7 -> "pqrs"
	8 -> "tuv"
	9 -> "wxyz"
	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	Note:
	Although the above answer is in lexicographical order, your answer could be in any order you want.
	 */
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
		if(digits == null || digits.length() < 1) return list;
		int n = Integer.parseInt(digits);
		int[] digit = new int[digits.length()];
		for(int i = digit.length - 1; i >= 0; i--){
			digit[i] = n % 10;
			n /= 10;
		}
		list = letterCombinations(digit, digit.length-1);
		return list;
    }
	List<String> letterCombinations(int[] digits, int k) {
		List<String> list = new ArrayList<String>();
		if(k >= 0){
			String a = letters[digits[k]];
			List<String> r = letterCombinations(digits, k -1);
			if(a.length() >= 1){
				for(int i = a.length() - 1; i >= 0; i--){
					String x = a.substring(i, i+1);
					list.addAll(copyList(r, x));
				}
			}else if(a.isEmpty()){
				list = r;
			}
		}		
		return list;
	}
	List<String> copyList(List<String> list, String a){
		List<String> ret = new ArrayList<String>(list.size());
		if(list.isEmpty()){
			ret.add(a);
		}else{
			for(String b: list){
				ret.add(b + a);
			}
		}
		return ret;
	}
	String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	void print(List<String> list){
		for(String a: list){
			System.out.print("->" + a);
		}
	}
	public static void main(String[] arg){
		LetterCombinationsOfPhoneNumber s = new LetterCombinationsOfPhoneNumber();
		List<String> list = s.letterCombinations("23");
		s.print(list);
		
	}
}
