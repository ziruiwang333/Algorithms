package leetcode.medium;

/**
 * Given two integers dividend and divisor, divide two integers without using 
 * multiplication, division, and mod operator.
 * 
 * The integer division should truncate toward zero, which means losing its 
 * fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would 
 * be truncated to -2.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * Note: Assume we are dealing with an environment that could only store integers 
 * within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, 
 * if the quotient is strictly greater than 231 - 1, then return 231 - 1, and 
 * if the quotient is strictly less than -231, then return -231.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/divide-two-integers/
 */

public class Divide_Two_Integers {

	public static void main(String[] args) {
		int dividend = 2147483647;
		int divisor = 1;
		System.out.println(mySol(dividend, divisor));
	}
	
	//Worded, but running time limited exceed. Should use bit operation (i.e. <<)
	public static int mySol(int dividend, int divisor) {
		long result = 0L;
		boolean isPositive = false;
		if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
			isPositive = true;
		}
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		while((dividend - divisor) >= 0) {
			dividend -= divisor;
			result++;
			if(result > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if(result < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
		}
		if(isPositive) {
			return (int) result;
		} else {
			return -(int)result;
		}
	}

}
