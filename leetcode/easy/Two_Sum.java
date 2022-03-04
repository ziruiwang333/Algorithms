package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, 
 * return indices of the two numbers such that they add 
 * up to target.You may assume that each input would have 
 * exactly one solution, and you may not use the same 
 * element twice.You can return the answer in any order.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/two-sum/
 *
 */

public class Two_Sum {

	public static void main(String[] args) {
		int[] nums = new int[] {2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(mySol(nums, target)));
		System.out.println(Arrays.toString(optimizedSol(nums, target)));
	}
	
	public static int[] mySol(int[] nums, int target) {
		int[] result = new int[2];
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i]+nums[j]==target) {
					result[0]= i;
					result[1] = j;
					return result;
				}
			}
		}
		return null;
	}
	
	//	Using Hashmap
	public static int[] optimizedSol(int[] nums, int target ) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			int temp = target-nums[i];
			if(map.get(temp)==null) {
				map.put(nums[i], i);
				continue;
			}
			int idx = map.get(temp);
			return new int[] {idx, i};
		}
		return null;
	}

}
