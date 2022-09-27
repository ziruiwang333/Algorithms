package leetcode.medium;

/**
 * You are given an integer array nums. You are initially positioned at the array's 
 * first index, and each element in the array represents your maximum jump length 
 * at that position.
 * 
 * Return true if you can reach the last index, or false otherwise.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/jump-game/
 */

public class Jump_Game {

	public static void main(String[] args) {
//		int[] nums = {3,2,1,0,4};
		int[] nums = {1,0,1,0};
		System.out.println(mySol(nums));
	}
	
	public static boolean mySol(int[] nums) {
		if(nums.length == 1) {
			return true;
		}
		for(int i=nums.length-1; i>=0; i--) {
			if(nums[i] == 0) {
				int count = 1;
				boolean canJump = false;
				for(int j=i-1; j>=0; j--) {
					if(nums[j]>count) {
						canJump = true;
						break;
					}
					if(nums[j] == count && j+nums[j]==nums.length-1) {
						canJump = true;
						break;
					}
					count++;
				}
				if(canJump) {
					continue;
				}
				return false;
			}
		}
		return true;
	}

}
