package leetcode.medium;

import java.util.HashMap;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, 
 * which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four 
 * is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it 
 * making four. The same principle applies to the number nine, which is written as IX. There are six instances 
 * where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/integer-to-roman/
 */

public class Integer_to_Roman {

	public static void main(String[] args) {
		int num = 1994;
		System.out.println(mySol(num));
	}
	
	public static String mySol(int num) {
		HashMap<Integer, String> hm = new HashMap<>();
		int[] keys = new int[] {1,4,5,9,10,40,50,90,100,400,500,900,1000};
		String[] values = new String[] {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
		for(int i=0; i<keys.length; i++) {
			hm.put(keys[i], values[i]);
		}
		StringBuilder sb = new StringBuilder();
		int keysPtr = keys.length-1;
		while(num != 0) {
			if(num-keys[keysPtr] >= 0) {
				num = num - keys[keysPtr];
				sb.append(hm.get(keys[keysPtr]));
			} else {
				keysPtr -= 1;
			}
		}
		return sb.toString();
	}
}
