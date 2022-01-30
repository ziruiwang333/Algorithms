package leetcode.easy;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead be stored inside 
 * the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements 
 * denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. 
 * nums2 has a length of n.
 * 
 * @author zirui
 *
 */

public class Merge_Sorted_Array {

	public static void main(String[] args) {
		int[] nums1 = new int[] {2,0};
		int m = 1;
		int[] nums2 = new int[] {1};
		int n = 1;
		mySol(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}
	
	public static void mySol(int[] nums1, int m, int[] nums2, int n) {
		int nums1Ptr = m-1;
		int nums2Ptr = n-1;
		int listPtr = m+n-1;
		while(nums2Ptr >= 0) {
			if(nums1Ptr < 0) {
				nums1[listPtr] = nums2[nums2Ptr];
				nums2Ptr--;
			}
			else if(nums1[nums1Ptr] > nums2[nums2Ptr]) {	
				nums1[listPtr] = nums1[nums1Ptr];
				nums1Ptr--;
			}
			else if(nums1[nums1Ptr] <= nums2[nums2Ptr]) {
				nums1[listPtr] = nums2[nums2Ptr];
				nums2Ptr--;
			}
			listPtr--;
		}
	}

}
