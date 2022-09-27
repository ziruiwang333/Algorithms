package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. 
 * You can return the answer in any order.
 * 
 * @author zirui
 *
 */

public class Permutations {

	public static void main(String[] args) {
		int[] nums = new int[] {0,1,2,3,4,5};
		List<List<Integer>> result = mySol(nums);
		Iterator<List<Integer>> iterator = result.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public static List<List<Integer>> mySol(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length == 1) {
			result.add(Arrays.asList(nums[0]));
			return result;
		}
		List<Integer> numsList = new ArrayList<>(nums.length);
		for(int i=0; i<nums.length; i++) {
			numsList.add(nums[i]);
		}
		helper(numsList, result, new ArrayList<>());
		return result;
	}
	
	public static void helper(List<Integer> nums, List<List<Integer>> result, List<Integer> element) {
		if(nums.size() == 0) {
			result.add(element);
			return;
		}
		for(int i=0; i<nums.size(); i++) {
			List<Integer> tempNums = new ArrayList<>(nums);
			List<Integer> tempElement = new ArrayList<Integer>(element);
			tempElement.add(nums.get(i));
			tempNums.remove(i);
			helper(tempNums, result, tempElement);
		}
	}

}
