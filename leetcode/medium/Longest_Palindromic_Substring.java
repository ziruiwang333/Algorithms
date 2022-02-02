package leetcode.medium;

import java.util.Arrays;

/**
 * Given a string s, return the longest palindromic substring in s.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/longest-palindromic-substring/
 */

public class Longest_Palindromic_Substring {

	public static void main(String[] args) {
		String s = "ac";
		System.out.println(mySol(s));
	}

	public static String mySol(String s) {
		if(s.length()<=1) {
			return s;
		}
		boolean[][] dpArray = new boolean[s.length()][s.length()];
		for(int i=0; i<dpArray.length; i++) {
			dpArray[i][i] = true;
		}
		for(int end=0; end<dpArray[0].length; end++) {
			for(int start=0; start<end; start++) {
				if(s.charAt(start) == s.charAt(end)) {
					if(start+1 == end) {
						dpArray[start][end] = true;
					} else {
						if(dpArray[start+1][end-1]) {
							dpArray[start][end] = true;
						}
					}
				}
			}
		}
		String result = "";
		int longest = 0;
		for(int end=dpArray.length-1; end>=0; end--) {
			for(int start=end; start>=0; start--) {
				if(dpArray[start][end] && (end+1-start)>longest) {
					longest = end + 1 - start;
					result = s.substring(start, end+1);
				}
			}
		}
		
		return result;
	}

}
