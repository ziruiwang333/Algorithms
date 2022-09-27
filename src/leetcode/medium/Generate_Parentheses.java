package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations 
 * of well-formed parentheses.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/generate-parentheses/
 */

public class Generate_Parentheses {

	public static void main(String[] args) {
		int n = 3;
		List<String> result = mySol(n);
		for(String s: result) {
			System.out.println(s);
		}
	}
	
	public static List<String> mySol(int n){
		ArrayList<String> result = new ArrayList<>();
		if(n==0) {
			return result;
		}
		helper(0, 0, n, new StringBuilder(), result);
		return result;
	}
	
	public static void helper(int left, int right, int n, StringBuilder sb, List<String> result) {
		if(left==n && right==n) {
			result.add(sb.toString());
			return;
		}
		if(left < n) {
			helper(left+1, right, n, new StringBuilder(sb).append("("), result);
		}
		if(left > right) {
			helper(left, right+1, n, new StringBuilder(sb).append(")"), result);
		}
	}
}
