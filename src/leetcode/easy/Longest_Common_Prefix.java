package leetcode.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 
 * @author zirui
 * @url https://leetcode.com/problems/longest-common-prefix/
 *
 */

public class Longest_Common_Prefix {

	public static void main(String[] args) {
		String[] strs = new String[]{"flower","flow","flight"};
		System.out.println(mySol(strs));
		System.out.println(optimizedSol(strs));
	}
	
	public static String mySol(String[] strs) {
		int minLen = strs[0].length();
		String prefix = "";
		for(int i=1; i<strs.length; i++) {
			if(strs[i].length() < minLen) {
				minLen = strs[i].length();
			}
		}
		for(int i=0; i<minLen; i++) {
			char temp = strs[0].charAt(i);
			for(int j=1; j<strs.length; j++) {
				if(strs[j].charAt(i) != temp) {
					return prefix;
				}
			}
			prefix = prefix + temp;
		}
		return prefix;
	}
	
	public static String optimizedSol(String[] strs) {
		if(strs.length==0) {
			return "";
		}
		String prefix = strs[0];
		for(int i=1; i<strs.length; i++) {
			while(strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0,prefix.length()-1);
				if(prefix.length() == 0) {
					return prefix;
				}
			}
		}
		return prefix;
	}

}
