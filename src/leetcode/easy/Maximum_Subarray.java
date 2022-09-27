package leetcode.easy;

/**
 * Given an integer array nums, find the contiguous subarray (containing 
 * at least one number) which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/maximum-subarray/
 */

public class Maximum_Subarray {

	public static void main(String[] args) {
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(mySol(nums));
		System.out.println(optimizedSol(nums));
	}
	
//	TOO SLOW, BAD
	public static int mySol(int[] nums) {
		int result = nums[0];
		for(int i=0; i<nums.length; i++) {
			int temp = nums[i];
			int tempMax = nums[i];
			for(int j=i+1; j<nums.length; j++) {
				temp = temp + nums[j];
				if(temp > tempMax) {
					tempMax = temp;
				}
			}
			if(tempMax > result) {
				result = tempMax;
			}
		}
		return result;
	}
	
	//Dynamic Programming - Kadane's algorithm
	public static int optimizedSol(int[] nums) {
		int[] maxArr = new int[nums.length];
		maxArr[0] = nums[0];
		for(int i=1; i<nums.length; i++) {
			if(maxArr[i-1] > 0) {
				maxArr[i] = maxArr[i-1] + nums[i];
			} else {
				maxArr[i] = nums[i];
			}
		}
		
		int result = maxArr[0];
		for(int i=1; i<maxArr.length; i++) {
			if(result < maxArr[i]) {
				result = maxArr[i];
			}
		}
		
		return result;
	}
	
}
