package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out 
 * of the range [1, n].
 * 
 * You may return the answer in any order.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/combinations/
 */

public class Combinations {

	public static void main(String[] args) {
		System.out.println(mySol(4,2));
	}
	
	public static List<List<Integer>> mySol(int n, int k) {
		int[] nums = new int[n+1];
		for(int i=1; i<=n; i++) {
			nums[i] = i;
		}
		List<List<Integer>> result = new ArrayList<>();
		helper(nums, 0, k, result, new ArrayList<>());
		return result;
	}
	
	public static void helper(int[] nums, int numsPtr, int k, List<List<Integer>> result, List<Integer> element) {
		if(element.size() == k) {
			result.add(new ArrayList<>(element));
			return;
		}
		for(int i=numsPtr; i<nums.length; i++) {
			if(nums[i] == 0) {
				continue;
			}
			element.add(nums[i]);
			int temp = nums[i];
			nums[i] = 0;
			helper(nums, i, k, result, element);
			element.remove(element.size()-1);
			nums[i] = temp;
		}
	}
	
}
