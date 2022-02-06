package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible 
 * letter combinations that the number could represent. Return the answer in 
 * any order.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given 
 * below. Note that 1 does not map to any letters.
 * 
 * 1		2(abc)	3(def)
 * 4(ghi)	5(jkl)	6(mno)
 * 7(pqrs)	8(tuv)	9(wxyz)
 * 
 * @author zirui
 *
 */

public class Letter_Combinations_of_a_Phone_Number {
	
	static HashMap<Character, String> hm = new HashMap<>();

	public static void main(String[] args) {
		String digits = "23";
		List<String> result = mySol(digits);
		for(String s: result) {
			System.out.println(s);
		}
	}
	
	public static List<String> mySol(String digits) {
		ArrayList<String> result = new ArrayList<>();
		if(digits.length() == 0) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		hm.put('2', "abc");
		hm.put('3', "def");
		hm.put('4', "ghi");
		hm.put('5', "jkl");
		hm.put('6', "mno");
		hm.put('7', "pqrs");
		hm.put('8', "tuv");
		hm.put('9', "wxyz");
		helper(result, sb, digits, 0);
		return result;
	}
	
	public static void helper(List<String> result, StringBuilder sb, String digits, int index) {
		if(index > digits.length()-1) {
			result.add(sb.toString());
			return;
		}
		char currDigit = digits.charAt(index);
		String s = hm.get(currDigit);
		for(int i=0; i<s.length(); i++) {
			sb.append(s.charAt(i));
			helper(result, sb, digits, index+1);
			sb.deleteCharAt(sb.length()-1);
		}
	}

}
