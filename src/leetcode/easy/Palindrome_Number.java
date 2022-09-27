package leetcode.easy;

/**
 * An integer is a palindrome when it reads the same backward as forward.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/palindrome-number/
 */

public class Palindrome_Number {

	public static void main(String[] args) {
		int x = 11;
		System.out.println(mySol(x));
		System.out.println(mySol2(x));
		System.out.println(optimizedSol(x));
	}
	
	public static boolean mySol(int x) {
		if(x<0)
			return false;
		String strVal = String.valueOf(x);
		int leftPtr = 0;
		int rightPtr = strVal.length()-1;
		while(leftPtr<=rightPtr) {
			if(strVal.charAt(leftPtr)!=strVal.charAt(rightPtr)) {
				return false;
			}
			leftPtr++;
			rightPtr--;
		}
		return true;
	}
	
	public static boolean mySol2(int x) {
		if(x<0)
			return false;
        int result = 0;
		int temp = x;
		while(temp!=0) {
			result = result*10 + temp%10;
			temp = temp/10;
		}
		if(result == x) {
			return true;
		}
		return false;
	}
	
	public static boolean optimizedSol(int x) {
		if((x%10==0 && x!=0) || x<0) {
			return false;
		}
		int result = 0;
		while(x > result) {
			result = result*10 + x%10;
			x = x/10;
		}
		return x==result || x==result/10;
	}

}
