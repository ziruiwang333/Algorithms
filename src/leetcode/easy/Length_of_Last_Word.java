package leetcode.easy;

/**
 * Given a string s consisting of some words separated by some number of spaces, 
 * return the length of the last word in the string.A word is a maximal substring 
 * consisting of non-space characters only.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/length-of-last-word/
 */

public class Length_of_Last_Word {

	public static void main(String[] args) {
		String s = "Hello World";
		System.out.println(mySol(s));
	}
	
	public static int mySol(String s) {
		int result = 0;
		for(int i=(s.length()-1); i>=0; i--) {
			if(s.charAt(i) != ' ') {
				result++;
				continue;
			}
			if(result != 0) {
			break;
			}
		}
		return result;
	}

}
