package leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets 
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in 
 * any order.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/subsets/
 */

public class Subsets {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		Iterator<List<Integer>> iterator = mySol(nums).iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public static List<List<Integer>> mySol(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return result;
		}
		List<Integer> temp = new ArrayList<>();
		result.add(temp);
		for(int i=0; i<nums.length; i++) {
			helper(nums, i, result, new ArrayList<>());
		}
		return result;
	}
	
	public static void helper(int[] nums, int currPos, List<List<Integer>> result, List<Integer> element) {
		if(currPos == nums.length) {
			result.add(element);
			return;
		}
		element.add(nums[currPos]);
		List<Integer> temp = new ArrayList<>();
		temp.addAll(element);
		result.add(temp);
		for(int i=currPos+1; i<nums.length; i++) {
			helper(nums, i, result, element);
		}
		element.remove(element.size()-1);
	}

}
