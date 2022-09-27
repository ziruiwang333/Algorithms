package leetcode.easy;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.An input string is valid if:Open brackets 
 * must be closed by the same type of brackets.Open brackets must be closed in the 
 * correct order.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/valid-parentheses/
 *
 */

public class Valid_Parentheses {

	public static void main(String[] args) {
		String s = "()[]{}";
		System.out.println(mySol(s));
	}
	
	public static boolean mySol(String s) {
		if(s.length()<2) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			char temp = s.charAt(i);
			if(temp=='(' || temp=='[' || temp=='{') {
				stack.push(temp);
				continue;
			}
			if(stack.empty()) {
				return false;
			}
			char popChar = stack.pop();
			if((popChar == '(' && temp!=')') || (popChar == '[' && temp!=']') || (popChar == '{' && temp!='}') ) {
				return false;
			}
		}
		return stack.empty();
	}

}
