package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/combination-sum-ii/
 */

public class Combination_Sum_2 {

	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> result = mySol(candidates, target);
		System.out.println(result.size());
		for(List<Integer> element: result) {
			for(int i: element) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> mySol(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<>();
		if(candidates.length == 0) {
			return result;
		}
		quickSort(candidates, 0, candidates.length-1);
		helper(candidates, 0, 0, target, result, new ArrayList<>());
		return result;
	}
	
	public static void helper(int[] nums, int currSum, int currIdx, int target, List<List<Integer>> result, List<Integer> element) {
		if(currSum == target) {
			result.add(element);
			return;
		}
		if(currSum > target) {
			return;
		}
		if(currSum < target) {
			for(int i=currIdx; i<nums.length; i++) {
				if(i!=currIdx && nums[i]==nums[i-1]) {
					continue;
				}
				List<Integer> temp = new ArrayList<>(element);
				temp.add(nums[i]);
				helper(nums, currSum+nums[i], i+1, target, result, temp);
			}
		}
	}
	
	public static void quickSort(int[] nums, int low, int high) {
		if(low >= high) {
			return;
		}
		int base = nums[low];
		int leftPtr = low + 1;
		int rightPtr = high;
		while(leftPtr <= rightPtr) {
			if(nums[leftPtr] <= base) {
				leftPtr++;
				continue;
			}
			if(nums[rightPtr] >= base) {
				rightPtr--;
				continue;
			}
			int temp = nums[leftPtr];
			nums[leftPtr] = nums[rightPtr];
			nums[rightPtr] = temp;
		}
		nums[low] = nums[rightPtr];
		nums[rightPtr] = base;
		quickSort(nums, low, rightPtr-1);
		quickSort(nums, rightPtr+1, high);
	}

}
