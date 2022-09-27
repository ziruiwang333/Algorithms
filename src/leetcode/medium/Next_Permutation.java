package leetcode.medium;

import java.util.Arrays;

/**
 * A permutation of an array of integers is an arrangement of its members into a 
 * sequence or linear order.
 * 
 * For example, for arr = [1,2,3], the following are considered permutations of arr: 
 * [1,2,3], [1,3,2], [3,1,2], [2,3,1].
 * 
 * The next permutation of an array of integers is the next lexicographically greater
 * permutation of its integer. More formally, if all the permutations of the array are 
 * sorted in one container according to their lexicographical order, then the next 
 * permutation of that array is the permutation that follows it in the sorted container. 
 * If such arrangement is not possible, the array must be rearranged as the lowest 
 * possible order (i.e., sorted in ascending order).
 * 
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not 
 * have a lexicographical larger rearrangement.
 * 
 * Given an array of integers nums, find the next permutation of nums.
 * 
 * The replacement must be in place and use only constant extra memory.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/next-permutation/
 */

public class Next_Permutation {

	public static void main(String[] args) {
		int[] nums = {2,3,1,3,3};
		mySol(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void mySol(int[] nums) {
		if(nums.length <= 1) {
			return;
		}
		
		for(int i=nums.length-1-1; i>=0; i--) {
			if(nums[i] >= nums[i+1]) {
				continue;
			}
			int tempIdx = i+1;
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] < nums[j]) {
					if(nums[j] <= nums[tempIdx]) {
						tempIdx = j;
					}
				}
			}
			System.out.println(i);
			int x = nums[i];
			nums[i] = nums[tempIdx];
			nums[tempIdx] = x;
			for(int left=i+1, right=nums.length-1; left<right; left++, right--) {
				int y = nums[left];
				nums[left] = nums[right];
				nums[right] = y;
			}
			return;
		}
		
		for(int i=0; i<nums.length/2; i++) {
			int x = nums[i];
			nums[i] = nums[nums.length-1-i];
			nums[nums.length-1-i] = x;
		}
	}
}
