package leetcode.easy;

import java.util.Arrays;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each 
 * i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/counting-bits/
 */

public class Counting_Bits {

	public static void main(String[] args) {
		int n = 0;
		System.out.println(Arrays.toString(mySol(n)));
	}
	
	public static int[] mySol(int n) {
		int[] result = new int[n+1];
		for(int i=1; i<result.length; i++) {
			int ones = 0;
			int num = i;
			while(num/2 != 0) {
				if(num%2 == 1) {
					ones++;
				}
				num = num / 2;
			}
			result[i] = ones+1;
		}
		return result;
	}

}
