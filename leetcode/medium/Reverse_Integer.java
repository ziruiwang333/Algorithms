package leetcode.medium;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. 
 * If reversing x causes the value to go outside the signed 32-bit integer 
 * range [-2^31, 2^31 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * 
 * @author zirui
 * @url https://leetcode.com/problems/reverse-integer/
 */

public class Reverse_Integer {

	public static void main(String[] args) {
		int x = -2147483648;
		System.out.println(mySol(x));
	}
	
	public static int mySol(int x) {
		long result = 0L;
		int x1 = x;
		while(x1/10 != 0) {
			result = result*10 + x1%10;
			x1 = x1/10;
		}
		if(x1 != 0) {
			result = result*10 + x1%10;
		}
		if(result > Integer.MAX_VALUE || result<Integer.MIN_VALUE) {
			return 0;
		}
		return (int) result;
	}

}
