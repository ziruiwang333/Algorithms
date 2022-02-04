package leetcode.medium;

import java.util.HashMap;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit 
 * signed integer (similar to C/C++'s atoi function).
 * 
 * The algorithm for myAtoi(string s) is as follows:
 * 1. Read in and ignore any leading whitespace.
 * 2. Check if the next character (if not already at the end of the string) 
 * is '-' or '+'. Read this character in if it is either. This determines if the 
 * final result is negative or positive respectively. Assume the result is positive 
 * if neither is present.
 * 3. Read in next the characters until the next non-digit character or the end of 
 * the input is reached. The rest of the string is ignored.
 * 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). 
 * If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * 5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], 
 * then clamp the integer so that it remains in the range. Specifically, integers 
 * less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * 6. Return the integer as the final result.
 * 
 * Note:
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/string-to-integer-atoi/
 */

public class String_to_Integer {

	public static void main(String[] args) {
		String s = "   -  42";
		System.out.println(mySol(s));
	}
	
	public static int mySol(String s) {
		boolean negative = false;
		boolean isAdd = false;
		boolean getSign = false;
		long result = 0L;
		char key = '0';
		HashMap<Character, Integer> hm = new HashMap<>();
		for(int i=0; i<10; i++) {
			hm.put(key++, i);
		}
		for(int i=0; i<s.length(); i++) {
			Integer digit = hm.get(s.charAt(i));
			if(digit != null) {
				result = result*10 + digit;
				isAdd = true;
				
				if(result > Integer.MAX_VALUE) {
					if(negative) {
						result = -result;
						if(result < Integer.MIN_VALUE) {
							return Integer.MIN_VALUE;
						} 
					}else {
						return Integer.MAX_VALUE;
					}
				}
			}
			else if(isAdd) {
				break;
			}
			if(s.charAt(i) == '-') {
				negative = true;
				isAdd = true;
				if(getSign) {
					return 0;
				}
				getSign = true;
			}
			else if(s.charAt(i) == '+') {
				negative = false;
				isAdd = true;
				if(getSign) {
					return 0;
				}
				getSign = true;
			}
			if(isAdd==false && (s.charAt(i)!='-' && s.charAt(i)!='+' && s.charAt(i)!=' ')) {
				return 0;
			}
		}
		return negative ? -(int) result : (int) result;
	}

}
