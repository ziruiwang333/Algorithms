package leetcode.easy;

import java.util.Arrays;

/**
 * You are given a large integer represented as an integer array digits, 
 * where each digits[i] is the ith digit of the integer. The digits are 
 * ordered from most significant to least significant in left-to-right order. 
 * The large integer does not contain any leading 0's.Increment the large 
 * integer by one and return the resulting array of digits.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/plus-one/
 */

public class Plus_One {

	public static void main(String[] args) {
		int[] digits = new int[] {1,2,3};
		System.out.println(Arrays.toString(mySol(digits)));
	}
	
	public static int[] mySol(int[] digits) {
		
		for(int i=digits.length-1; i>=0; i--) {
			if(digits[i] != 9) {
				digits[i] += 1;
				break;
			}
			digits[i] = 0;
		}
		if(digits[0] == 0) {
			int[] result = new int[digits.length+1];
			result[0] = 1;
			return result;
		}
		return digits;
	}

}
