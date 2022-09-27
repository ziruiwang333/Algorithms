package leetcode.medium;

/**
 * Given two non-negative integers num1 and num2 represented as strings, 
 * return the product of num1 and num2, also represented as a string.
 * 
 * Note: You must not use any built-in BigInteger library or convert the inputs 
 * to integer directly.
 * 
 * @author zirui
 *
 */

public class Multiply_Strings {

	public static void main(String[] args) {
		String num1 = "123";
		String num2 = "456";
		System.out.println(mySol(num1, num2));
	}
	
	public static String mySol(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int[] result = new int[num1.length() + num2.length()];
		for(int num2Ptr = num2.length()-1; num2Ptr>=0; num2Ptr--) {
			int resultPtr = num1.length() + num2Ptr;
			for(int num1Ptr = num1.length()-1; num1Ptr>=0; num1Ptr--) {
				int currNum1 = num1.charAt(num1Ptr) - '0';
				int currNum2 = num2.charAt(num2Ptr) - '0';
				result[resultPtr] += currNum1 * currNum2;
				resultPtr--;
			}
		}
		int carry = 0;
		for(int i=result.length-1; i>=0; i--) {
			int currNum = result[i] + carry;
			result[i] = currNum % 10;
			carry = currNum / 10;
		}
		StringBuilder sb = new StringBuilder();
		boolean start = false;
		for(int i=0; i<result.length; i++) {
			if(result[i]==0 && !start) {
				continue;
			}
			sb.append(result[i]);
			start = true;
		}
		return sb.toString();
	}
}
