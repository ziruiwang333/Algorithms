package leetcode.medium;

/**
 * Given an array of non-negative integers nums, you are initially positioned at 
 * the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * You can assume that you can always reach the last index.
 * 
 * @author zirui
 *
 */

public class Jump_Game_2 {

	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1,1};
		System.out.println(mySol(nums));
	}
	
	public static int mySol(int[] nums) {
		if(nums.length == 1) {
			return 0;
		}
		int result = 0;
		for(int currPos=0; currPos<nums.length-1;) {
			int nextSteps = nums[currPos];
			int nextPos = 0;
			int nextMaxDist = 0;
			for(int i=currPos+1; i<=currPos + nextSteps;i++) {
				if(i >= nums.length-1) {
					return ++result;
				}
				if( (nums[i]+(i-currPos)) > nextMaxDist ) {
					nextMaxDist = nums[i]+(i-currPos);
					nextPos = i;
				}
			}
			currPos = nextPos;
			result++;
		}
		return ++result;
	}

}
