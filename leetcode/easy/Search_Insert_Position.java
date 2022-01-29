package leetcode.easy;

/**
 * Given a sorted array of distinct integers and a target value, 
 * return the index if the target is found. If not, 
 * return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/search-insert-position/
 *
 */

public class Search_Insert_Position {

	public static void main(String[] args) {
		int[] nums = new int[] {1,3};
		int target = 5;
		System.out.println(mySol(nums, target));
	}
	
	public static int mySol(int[] nums, int target) {
		if(nums.length==0) {
			return 0;
		}
		
		int leftPtr = 0;
		int rightPtr = nums.length;
		int mid = 0;
		
		while(leftPtr <= rightPtr) {
			mid = (leftPtr + rightPtr) / 2;
			if(mid > nums.length-1 || nums[mid] == target) {
				return mid;
			}
			if(nums[mid] > target) {
				rightPtr = mid-1;
			}
			else if(nums[mid] < target) {
				leftPtr = mid+1;
			}
		}
		
		return leftPtr;
	}

}
