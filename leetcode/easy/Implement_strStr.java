package leetcode.easy;

/**
 * Return the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/implement-strstr/
 *
 */

public class Implement_strStr {

	public static void main(String[] args) {
		System.out.println(mySol("hello", "ll"));
	}
	
	public static int mySol(String haystack, String needle) {
		if(needle.length() == 0) {
			return 0;
		}
		return KMP(haystack.toCharArray(),  needle.toCharArray());
	}
	
	public static int KMP(char[] haystack, char[] needle) {
		int[] next = getNextArray(needle);
		int arrPtr=0, nextPtr=0;
		
		while(arrPtr<haystack.length && nextPtr<needle.length) {
			if(haystack[arrPtr] == needle[nextPtr]) {
				arrPtr++;
				nextPtr++;
				continue;
			}
			if(nextPtr == 0) {
				arrPtr++;
			} else {
				nextPtr = next[nextPtr-1] + 1;
			}
		}
		
		return nextPtr==needle.length ? (arrPtr-needle.length) : -1;
	}
	
	public static int[] getNextArray(char[] needle) {
		int[] next = new int[needle.length];
		next[0] = -1;
		
		int pre;
		for(int i=1; i<needle.length; i++) {
			pre = next[i-1];
			
			while(pre >= 0 && needle[pre+1] != needle[i]) {
				pre = next[pre];
			}
			
			if(needle[pre+1] == needle[i]) {
				next[i] = pre + 1;
			} else {
				next[i] = -1;
			}
			
		}
		
		return next;
	}

}
