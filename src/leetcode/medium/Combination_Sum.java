package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, 
 * return a list of all unique combinations of candidates where the chosen 
 * numbers sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times. 
 * Two combinations are unique if the frequency of at least one of the chosen 
 * numbers is different.
 * 
 * It is guaranteed that the number of unique combinations that sum up to target 
 * is less than 150 combinations for the given input.
 * 
 * @author zirui
 *
 */

public class Combination_Sum {

	public static void main(String[] args) {
		int[] candidates = {2,3,5};
		int target = 5;
		List<List<Integer>> result = mySol(candidates, target);
		for(List<Integer> element: result) {
			for(int i: element) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> mySol(int[] candidates, int target){
		ArrayList<List<Integer>> result = new ArrayList<>();
		for(int i=0; i<candidates.length; i++) {
			helper(candidates, i, 0, target, result, new ArrayList<>());
		}
		return result;
	}
	
	public static void helper(int[] nums, int numsPtr, int currSum, int target, List<List<Integer>> result, List<Integer> element) {
		if(currSum + nums[numsPtr] == target) {
			element.add(nums[numsPtr]);
			result.add(element);
			return;
		}
		if(currSum + nums[numsPtr] > target) {
			return;
		}
		if(currSum + nums[numsPtr] < target) {
			for(int i=numsPtr; i<nums.length; i++) {
				ArrayList<Integer> temp = new ArrayList<Integer>(element);
				temp.add(nums[numsPtr]);
				helper(nums, i, currSum + nums[numsPtr], target, result, temp);
			}
		}
	}

}
