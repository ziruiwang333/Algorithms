package leetcode.medium;

/**
 * There is an integer array nums sorted in non-decreasing order (not necessarily 
 * with distinct values).
 * 
 * Before being passed to your function, nums is rotated at an unknown pivot 
 * index k (0 <= k < nums.length) such that the resulting array is 
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] 
 * (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot 
 * index 5 and become [4,5,6,6,7,0,1,2,4,4].
 * 
 * Given the array nums after the rotation and an integer target, return true if 
 * target is in nums, or false if it is not in nums.
 * 
 * You must decrease the overall operation steps as much as possible.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */

public class Search_in_Rotated_Sorted_Array_2 {

	public static void main(String[] args) {
		int[] nums = {1,0,1,1,1};
		System.out.println(mySol(nums, 0));
	}
	
	public static boolean mySol(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(nums[mid] == target) {
				return true;
			}
			if(target > nums[mid]) {
				if(target > nums[right]) {
					if(nums[left] == nums[right]) {
						left = mid + 1;
						continue;
					}
					right = mid - 1;
					continue;
				}
				else {
					if(nums[left] == nums[right]) {
						right = mid - 1;
						continue;
					}
					left = mid + 1;
					continue;
				}
			}
			if(target < nums[mid]) {
				if(target  < nums[left]) {
					if(nums[left] == nums[right]) {
						right = mid - 1;
						continue;
					}
					left = mid + 1;
					continue;
				}
				else {
					if(nums[left] == nums[right]) {
						left = mid + 1;
						continue;
					}
					right = mid - 1;
					continue;
				}
			}
		}
		return false;
	}

}
