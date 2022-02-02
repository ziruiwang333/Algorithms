package leetcode.medium;

/**
 * Given a string s, find the length of the longest substring 
 * without repeating characters.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		String s = "abcabcbbabcabcbb";
		System.out.println(mySol(s));
	}
	
	public static int mySol(String s) {
		if(s.length() == 0) {
			return 0;
		}
		int result = 1;
		String tempStr = s.substring(0, 1);
		for(int i=1; i<s.length(); i++) {
			boolean add = true;
			for(int j=0; j<tempStr.length(); j++) {
				if(s.charAt(i) == tempStr.charAt(j)) {
					add = false;
					if(tempStr.length() > result) {
						result = tempStr.length();
					}
					tempStr = tempStr.substring(j+1);
					tempStr += s.substring(i, i+1);
					break;
				}
			}
			if(add) {
				tempStr += s.substring(i, i+1);
			}
		}
		return tempStr.length() > result ? tempStr.length() : result;
	}

}
