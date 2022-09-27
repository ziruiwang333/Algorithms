package leetcode.easy;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated, 
 * and only the integer part of the result is returned.
 * Note: You are not allowed to use any built-in exponent function or operator, 
 * such as pow(x, 0.5) or x ** 0.5.
 * 
 * @author zirui
 *
 */

public class Sqrt_x {

	public static void main(String[] args) {
		int x = 1000000;
		System.out.println(mySol(x));
	}
	
	public static int mySol(int x) {
		int leftPtr = 0;
		int rightPtr = x;
		while(leftPtr < rightPtr) {
			long mid = (leftPtr + rightPtr)/2;
			if(mid*mid > x) {
				rightPtr = (int) (mid-1);
			}
			else if(mid*mid < x) {
				leftPtr = (int) (mid+1);
			}
			else if(mid*mid == x) {
				return (int) mid;
			}
		}
		return rightPtr*rightPtr>x ? rightPtr-1 : rightPtr;
	}

}
