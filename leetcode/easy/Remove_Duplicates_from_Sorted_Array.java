package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an integer array nums sorted in non-decreasing order, 
 * remove the duplicates in-place such that each unique element 
 * appears only once. The relative order of the elements should 
 * be kept the same.Since it is impossible to change the length 
 * of the array in some languages, you must instead have the 
 * result be placed in the first part of the array nums. More 
 * formally, if there are k elements after removing the duplicates, 
 * then the first k elements of nums should hold the final result. 
 * It does not matter what you leave beyond the first k elements.
 * Return k after placing the final result in the first k slots of nums.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

public class Remove_Duplicates_from_Sorted_Array {

	public static void main(String[] args) {
		int[] nums = new int[] {1,1,2,2,3,3,3,3,4,5,6,6,6};
		System.out.println(mySol(nums));
		System.out.println(Arrays.toString(nums));
		System.out.println("***************mySol2*******************");
		System.out.println(mySol2(nums));
		System.out.println(Arrays.toString(nums));
	}
	
	/**
	 * Not efficient
	 * @param nums
	 * @return
	 */
	public static int mySol(int[] nums) {
		if(nums.length<2) {
			return nums.length;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			map.put(nums[i], i);
		}
		
		int indexPtr = 1;
		int preNum = nums[0];
		for(int i=1; i<nums.length; i++) {
			int tempIdx = map.get(nums[i]);
			if(nums[i] != preNum) {
				nums[indexPtr] = nums[tempIdx];
				preNum = nums[i];
				indexPtr++;
			}
		}
		return map.size();
	}
	
	/**
	 * BETTER!
	 * @param nums
	 * @return
	 */
	public static int mySol2(int[] nums) {
		if(nums.length<2) {
			return nums.length;
		}
		int indexPtr = 1;
		int preValue = nums[0];
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != preValue && nums[i] > preValue) {
				nums[indexPtr] = nums[i];
				preValue = nums[i];
				indexPtr++;
			}
		}
		return indexPtr;
	}

}
