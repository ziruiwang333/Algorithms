package leetcode.medium;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them 
 * in-place so that objects of the same color are adjacent, with the colors in 
 * the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/sort-colors/
 */

public class Sort_Colors {

	public static void main(String[] args) {
		int[] nums = {2};
		mySol(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void mySol(int[] nums) {
		int redCount = 0;
		int whiteCount = 0;
		int blueCount = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == 0) {
				redCount++;
			}else if(nums[i]==1){
				whiteCount++;
			}else if(nums[i]==2) {
				blueCount++;
			}
		}
		for(int i=0; i<nums.length; i++) {
			if(i<redCount) {
				nums[i] = 0;
			} else if(i < whiteCount + redCount) {
				nums[i] = 1;
			} else if(i < whiteCount + redCount + blueCount) {
				nums[i] = 2;
			}
		}
	}

}
