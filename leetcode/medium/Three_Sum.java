package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, 
 * and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/3sum/
 */

public class Three_Sum {

	public static void main(String[] args) {
		int[] nums = new int[] {-1,0,1,2,-1,-4};
		List<List<Integer>> result = mySol(nums);
		for(List<Integer> ele: result) {
			System.out.print("[");
			for(Integer i: ele) {
				System.out.print(i);
			}
			System.out.println("]");
		}
	}
	
	public static List<List<Integer>> mySol(int[] nums){
		ArrayList<List<Integer>> resultList = new ArrayList<>();
		if(nums.length < 3) {
			return resultList;
		}
		quickSort(nums, 0, nums.length-1);
		for(int i=0; i<nums.length; i++) {
			if(i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int leftPtr = i+1;
			int rightPtr = nums.length-1;
			while(leftPtr < rightPtr) {
				if(leftPtr != i+1 && nums[leftPtr]==nums[leftPtr-1]) {
					leftPtr++;
					continue;
				}
				if(nums[i] + nums[leftPtr] + nums[rightPtr] == 0) {
					ArrayList<Integer> element = new ArrayList<Integer>();
					element.add(nums[i]);
					element.add(nums[leftPtr]);
					element.add(nums[rightPtr]);
					resultList.add(element);
					leftPtr++;
					rightPtr--;
				}
				if(nums[i] + nums[leftPtr] + nums[rightPtr] > 0) {
					rightPtr--;
					continue;
				}
				if(nums[i] + nums[leftPtr] + nums[rightPtr] < 0) {
					leftPtr++;
					continue;
				}
			}
		}
		return resultList;
	}
	
	public static void quickSort(int[] nums, int low, int high) {
		if(low >= high) {
			return;
		}
		int base = nums[low];
		int i = low+1;
		int j = high;
		
		while(i <= j) {
			if(nums[i] <= base) {
				i++;
				continue;
			}
			if(nums[j] >= base) {
				j--;
				continue;
			}
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		nums[low] = nums[j];
		nums[j] = base;
		quickSort(nums, low, j-1);
		quickSort(nums, j+1, high);
	}

}
