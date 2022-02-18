package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Given a collection of numbers, nums, that might contain duplicates, 
 * return all possible unique permutations in any order.
 * 
 * @author zirui
 *
 */

public class Permutations_2 {

	public static void main(String[] args) {
		int[] nums = {1,1,2};
		Iterator<List<Integer>> iter = mySol(nums).iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public static List<List<Integer>> mySol(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length == 1) {
			result.add(Arrays.asList(nums[0]));
			return result;
		}
		quickSort(nums, 0, nums.length-1);
		int[] visited = new int[nums.length];
		helper(nums, visited, result, new ArrayList<>());
		return result;
	}
	
	public static void helper(int[] nums, int[] visited, List<List<Integer>> result, List<Integer> element) {
		if(element.size() == nums.length) {
			result.add(new ArrayList<>(element));
			return;
		}
		for(int i=0; i<nums.length; i++) {
			if(visited[i] == 1) {
				continue;
			}
			if(i!=0 && nums[i]==nums[i-1] && visited[i-1] == 0) {
				continue;
			}
			element.add(nums[i]);
			visited[i] = 1;
			helper(nums, visited, result, element);
			visited[i] = 0;
			element.remove(element.size()-1);
		}
	}
	
	public static void quickSort(int[] nums, int low, int high){
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
