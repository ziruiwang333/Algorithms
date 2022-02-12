package leetcode.medium;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting 
 * and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {

	public static void main(String[] args) {
		int[] nums = {1};
		int target = 1;
		System.out.println(Arrays.toString(mySol(nums, target)));
	}
	
	public static int[] mySol(int[] nums, int target) {
		int[] result = {-1, -1};
		int leftPtr = 0;
		int rightPtr = nums.length-1;
		int targetIdx = -1;
		while(leftPtr <= rightPtr) {
			int mid = (leftPtr + rightPtr) / 2;
			if(nums[mid] == target) {
				targetIdx = mid;
				break;
			}
			if(nums[mid] > target) {
				rightPtr = mid - 1;
				continue;
			}
			if(nums[mid] < target) {
				leftPtr = mid + 1;
				continue;
			}
		}
		if(targetIdx == -1) {
			return result;
		}
		leftPtr = targetIdx;
		rightPtr = targetIdx;
		while(leftPtr >= 0 && nums[leftPtr] == target) {
			leftPtr--;
		}
		while(rightPtr <= nums.length-1 && nums[rightPtr] == target) {
			rightPtr++;
		}
		result[0] = leftPtr+1;
		result[1] = rightPtr-1;
		return result;
	}

}
