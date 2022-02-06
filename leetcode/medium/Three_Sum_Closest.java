package leetcode.medium;

/**
 * Given an integer array nums of length n and an integer target, find three 
 * integers in nums such that the sum is closest to target.
 * 
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/3sum-closest/
 */

public class Three_Sum_Closest {

	public static void main(String[] args) {
		int[] nums = new int[] {-1,2,1,-4};
		System.out.println(mySol(nums, 1));
	}
	
	public static int mySol(int[] nums, int target) {
		int result = 0;
		int diff =Integer.MAX_VALUE;
		quickSort(nums, 0, nums.length-1);
		for(int i=0; i<nums.length; i++) {
			if(i!=0 && nums[i-1] == nums[i]) {
				continue;
			}
			int leftPtr = i+1;
			int rightPtr = nums.length-1;
			while(leftPtr < rightPtr) {
				int tempSum = nums[i] + nums[leftPtr] + nums[rightPtr];
				int tempDiff = tempSum - target;
				if(Math.abs(tempDiff) < Math.abs(diff)) {
					diff = tempDiff;
					result = tempSum;
				}
				if(tempDiff > 0) {
					rightPtr--;
				}
				if(tempDiff < 0) {
					leftPtr++;
				}
				if(tempDiff == 0) {
					return result;
				}
			}
		}
		return result;
	}
	
	public static void quickSort(int[] nums, int low, int high) {
		if(low >= high) {
			return;
		}
		int base = nums[low];
		int lowPtr = low + 1;
		int highPtr = high;
		while(lowPtr <= highPtr) {
			if(nums[lowPtr] <= base) {
				lowPtr++;
				continue;
			}
			if(nums[highPtr] >= base) {
				highPtr--;
				continue;
			}
			int temp = nums[lowPtr];
			nums[lowPtr] = nums[highPtr];
			nums[highPtr] = temp;
		}
		nums[low] = nums[highPtr];
		nums[highPtr] = base;
		quickSort(nums, low, highPtr-1);
		quickSort(nums, highPtr+1, high);
	}

}
