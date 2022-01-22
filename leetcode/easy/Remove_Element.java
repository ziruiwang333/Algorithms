package leetcode.easy;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer val, remove all 
 * occurrences of val in nums in-place. The relative order of 
 * the elements may be changed.Since it is impossible to change 
 * the length of the array in some languages, you must instead 
 * have the result be placed in the first part of the array nums. 
 * More formally, if there are k elements after removing the duplicates, 
 * then the first k elements of nums should hold the final result. 
 * It does not matter what you leave beyond the first k elements.
 * Return k after placing the final result in the first k slots of nums.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/remove-element/
 */

public class Remove_Element {

	public static void main(String[] args) {
		int[] nums = new int[] {0,1,2,2,3,0,4,2};
		int val = 2;
		System.out.println(mySol(nums, val));
		System.out.println(Arrays.toString(nums));
		
	}
	
	public static int mySol(int[] nums, int val) {
		if(nums.length==0 || nums==null) {
			return 0;
		}
		int indexPtr = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != val) {
				nums[indexPtr] = nums[i];
				indexPtr++;
			}
		}
		return indexPtr;
	}

}
