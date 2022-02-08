package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique 
 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 
 * You may return the answer in any order.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/4sum/
 */

public class Four_Sum {

	public static void main(String[] args) {
		int[] nums = new int[] {-1,2,2,-5,0,-1,4};
		quickSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
		List<List<Integer>> result = mySol(nums, 3);
		for(List<Integer> i: result) {
			System.out.println(i);
		}
	}
	
	public static List<List<Integer>> mySol(int[] nums, int target){
		ArrayList<List<Integer>> result = new ArrayList<>();
		if(nums.length < 4) {
			return result;
		}
		quickSort(nums, 0, nums.length-1);
		for(int i=0; i<nums.length; i++) {
			if(i!=0 && nums[i] == nums[i-1]) {
				continue;
			}
			for(int j=i+1; j<nums.length; j++) {
				if(j!=i+1 && nums[j] == nums[j-1]) {
					continue;
				}
				int leftPtr = j+1;
				int rightPtr = nums.length-1;
				while(leftPtr < rightPtr) {
					if(leftPtr != j+1 && nums[leftPtr] == nums[leftPtr-1]) {
						leftPtr++;
						continue;
					}
					int currSum = nums[i] + nums[j] + nums[leftPtr] + nums[rightPtr];
					if(currSum == target) {
						ArrayList<Integer> element = new ArrayList<>();
						element.add(nums[i]);
						element.add(nums[j]);
						element.add(nums[leftPtr]);
						element.add(nums[rightPtr]);
						result.add(element);
						leftPtr++;
						rightPtr--;
					}
					else if(currSum > target) {
						rightPtr--;
					}
					else if(currSum < target) {
						leftPtr++;
					}
				}
			}
		}
		return result;
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
