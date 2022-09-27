package leetcode.medium;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * 
 * Prior to being passed to your function, nums is possibly rotated at an unknown 
 * pivot index k (1 <= k < nums.length) such that the resulting array is 
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target, 
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

public class Search_in_Rotated_Sorted_Array {

	public static void main(String[] args) {
		int[] nums = {1,3};
		System.out.println(mySol(nums, 3));
	}
	
	public static int mySol(int[] nums, int target) {
		if(nums.length == 1) {
			return nums[0] == target?0:-1;
		}
		int leftPtr = 0;
		int rightPtr = nums.length-1;
		while((leftPtr != rightPtr) && (leftPtr+1 != rightPtr)) {
			int mid = (leftPtr + rightPtr)/2;
			if(nums[mid] < nums[0]) {
				rightPtr = mid;
				continue;
			}
			if(nums[mid] > nums[0]) {
				leftPtr = mid;
				continue;
			}
		}
		int baseIdx = rightPtr;
		if(baseIdx == nums.length-1 && nums[baseIdx] > nums[0]) {
			baseIdx = 0;
		}
		if(target <= nums[nums.length-1]) {
			leftPtr = baseIdx;
			rightPtr = nums.length-1;
		}
		else if (target >= nums[0]) {
			leftPtr = 0;
			rightPtr = baseIdx-1;
		}
		while(leftPtr <= rightPtr) {
			int mid = (leftPtr + rightPtr)/2;
			if(nums[mid] == target) {
				return mid;
			}
			if(target > nums[mid]) {
				leftPtr = mid+1;
				continue;
			}
			if(target < nums[mid]) {
				rightPtr = mid-1;
				continue;
			}
		}
		return -1;
	}

}
