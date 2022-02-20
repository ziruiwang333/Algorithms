package leetcode.medium;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * 
 * @author zirui
 * @url https://leetcode.com/problems/powx-n/
 */

public class Power_x_n {

	public static void main(String[] args) {
		System.out.println(mySol(2, -2));
	}
	
	//Not efficient
	public static double mySol(double x, int n) {
		if(x == 1) {
			return 1;
		}
		double result = x;
		if (n > 0) {
			while (n > 1) {
				result *= x;
				n--;
			}
		} else if (n < 0) {
			result = 1/x;
			while (n < -1) {
				result /= x;
				n++;
			}
		} else {
			return  1;
		}
		return result;
	}

}
