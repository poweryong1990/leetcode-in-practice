package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	/**
	 * Given a string s and a dictionary of words dict, 
	 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
	
	For example, given
	s = "leetcode",
	dict = ["leet", "code"].
	
	Return true because "leetcode" can be segmented as "leet code".
	 */
	public boolean wordBreak(String s, Set<String> dict) {
		return separate(s, 0, 1, dict) > -1;
    }
	int separate(String s, int i, int j, Set<String> dict){
		if(i >=s.length() || j > s.length()) return -1;
		String word = s.substring(i, j);
		if(dict.contains(word)){
			if(j == s.length()) return j;
			int j2 = separate(s, j, j + 1, dict);
			if(j2 > -1){
				return j2;
			}
			return separate(s, i, j + 1, dict);
		}else{
			return separate(s, i, j + 1, dict);
		}
	}
	public boolean wordBreak2(String s, Set<String> dict) {
		int len = s.length();
		boolean[] breakable = new boolean[len + 1];
		breakable[0] = true;
		for(int i = 1; i <= len; i ++){
			for(int j = i - 1; j >= 0; j--){
				if(breakable[j] && dict.contains(s.substring(j, i))){
					breakable[i] = true;
					break;
				}
			}
		}
		return breakable[len];
	}
	/**
	 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
	
	Return all such possible sentences.
	
	For example, given
	s = "catsanddog",
	dict = ["cat", "cats", "and", "sand", "dog"].
	
	A solution is ["cats and dog", "cat sand dog"].
	 */
	public List<String> wordBreakII(String s, Set<String> dict) {
		int len = s.length();
		boolean[] breakable = new boolean[len + 1];
		breakable[0] = true;
		for(int i = 1; i <= len; i ++){
			for(int j = i - 1; j >= 0; j--){
				if(breakable[j] && dict.contains(s.substring(j, i))){
					breakable[i] = true;
					break;
				}
			}
		}
		List<String> list = new ArrayList<String>();
		if(breakable[len]){
			list = wordBreakII(s, dict, breakable, len);
		}
		return list;
    }
	List<String> wordBreakII(String s, Set<String> dict, boolean[] breakable, int k){
		List<String> list = new ArrayList<String>();
		for(int i = k - 1; i >= 0; i--){
			if(!breakable[i]) continue;
			String word = s.substring(i, k);
			if(dict.contains(word)){
				if(0 == i){
					list.add(word);
					return list;
				}
				List<String> a = wordBreakII(s, dict, breakable, i);
				for(int j = 0; j < a.size(); j++){
					a.set(j, a.get(j) + " " + word);
				}
				list.addAll(a);
			}
		}
		return list;
	}
	void print(List<String> list){
		for(String s: list){
			System.out.println(s);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak s = new WordBreak();
		String a = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("leetco");
		dict.add("de");
		System.out.println(s.wordBreak(a, dict) + ", " + s.wordBreak2(a, dict));
		
		String b = "catsanddog";
		dict.clear();
		dict.add("cat");//"cat", "cats", "and", "sand", "dog"
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		List<String> list = s.wordBreakII(b, dict);
		s.print(list);
	}

}
