package leetcode.medium;

import java.util.Stack;

/**
 * Given a string path, which is an absolute path (starting with a slash '/') to a 
 * file or directory in a Unix-style file system, convert it to the simplified 
 * canonical path.
 * 
 * In a Unix-style file system, a period '.' refers to the current directory, a 
 * double period '..' refers to the directory up a level, and any multiple 
 * consecutive slashes (i.e. '//') are treated as a single slash '/'. For this 
 * problem, any other format of periods such as '...' are treated as file/directory 
 * names.
 * 
 * 
 * The canonical path should have the following format:
 * 
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to 
 * the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/simplify-path/
 */

public class Simplify_Path {

	public static void main(String[] args) {
		String path = "/...da/adf/";
		System.out.println(optimizedSol(path));
		System.out.println(mySol(path));
	}
	
	public static String optimizedSol(String path) {
		String[] strArr = path.split("/");
		Stack<String> stack = new Stack<>();
		for(int i=0; i<strArr.length; i++) {
			if(strArr[i].length()==0 || strArr[i].equals(".")) {
				continue;
			}
			if(strArr[i].equals("..")) {
				if(!stack.isEmpty()) {
					stack.pop();
				}
				continue;
			}
			stack.add(strArr[i]);
		}
		StringBuilder result = new StringBuilder();
		while(!stack.isEmpty()) {
			result.insert(0, "/" + stack.pop());
		}
		return result.length()==0 ? "/" : result.toString();
	}
	
	//Complexity
	public static String mySol(String path) {
		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int dotCount = 0;
		path = path + "/";
		for (int i = 1; i < path.length(); i++) {
			char currChar = path.charAt(i);
			sb.append(currChar);
			if(currChar == '.') {
				dotCount++;
			}
			else if(currChar == '/' || i==path.length()-1) {
				if(dotCount == 2 && sb.length()==3) {
					if(!stack.isEmpty()){ 
						stack.pop();
					}
				}
				else if(((dotCount <= 2 && sb.length() != dotCount+1) || dotCount>=3) && sb.length() != 1) {
					stack.add(sb.substring(0, sb.length()-1));
				}
				dotCount = 0;
				sb = new StringBuilder();
			}
			else {
				dotCount = 0;
			}
		}
		StringBuilder result = new StringBuilder();
		while(!stack.isEmpty()) {
			result.insert(0, "/"+stack.pop());
		}
		return result.toString().length()==0 ? "/" : result.toString();
	}

}
