package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a sorted unique integer array nums.
 * 
 * Return the smallest sorted list of ranges that cover all the numbers in the 
 * array exactly. That is, each element of nums is covered by exactly one of the 
 * ranges, and there is no integer x such that x is in one of the ranges but not 
 * in nums.
 * 
 * Each range [a,b] in the list should be output as:
 * "a->b" if a != b
 * "a" if a == b
 * 
 * @author zirui
 * @url https://leetcode.com/problems/summary-ranges/
 */

public class Summary_Ranges {

	public static void main(String[] args) {
		int[] nums = {0,1,2,4,5,7};
		System.out.println(mySol(nums));
	}
	
	public static List<String> mySol(int[] nums){
		List<String> result = new ArrayList<>();
		if(nums.length == 0) {
			return result;
		}
		int start = nums[0];
		int end = nums[0];
		for(int i=1; i<nums.length; i++) {
			if(nums[i] == nums[i-1]+1) {
				end = nums[i];
				continue;
			}
			result.add(start==end ? new StringBuilder().append(start).toString() : start + "->" + end);
			start = nums[i];
			end = nums[i];
		}
		result.add(start==end ? new StringBuilder().append(start).toString() : start + "->" + end);
		return result;
	}

}
