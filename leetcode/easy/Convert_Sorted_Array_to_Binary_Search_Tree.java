package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.lib.treeNode.TreeNode;

/**
 * Given an integer array nums where the elements are sorted in ascending order, 
 * convert it to a height-balanced binary search tree.
 * 
 * A height-balanced binary tree is a binary tree in which the depth of the two 
 * subtrees of every node never differs by more than one.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

public class Convert_Sorted_Array_to_Binary_Search_Tree {

	public static void main(String[] args) {
		int[] nums = {-10,-3,0,5,9};
//		TreeNode root = mySol(nums);
		TreeNode root = optimizedSol(nums);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		System.out.print("[" + root.val);
		while(q.peek() != null) {
			TreeNode currNode = q.poll();
			if(currNode.left != null) {
				System.out.print(" " + currNode.left.val);
				q.add(currNode.left);
			}
			else if(currNode.left != null || currNode.right != null) {
				System.out.print(" null");
			}
			if(currNode.right != null) {
				System.out.print(" " + currNode.right.val);
				q.add(currNode.right);
			}
			else if(currNode.left != null || currNode.right != null) {
				System.out.print(" null");
			}
		}
		System.out.println("]");
	}
	
	public static TreeNode optimizedSol(int[] nums) {
		if(nums.length == 0) {
			return null;
		}
		TreeNode root = optimizedSolHelper(nums, 0, nums.length-1);
		return root;
	}
	
	public static TreeNode optimizedSolHelper(int[] nums, int leftPtr, int rightPtr) {
		if(leftPtr > rightPtr) {
			return null;
		}
		int currVal = nums[(leftPtr + rightPtr)/2];
		TreeNode leftNode = optimizedSolHelper(nums, leftPtr, (leftPtr + rightPtr)/2-1);
		TreeNode rightNode = optimizedSolHelper(nums, (leftPtr + rightPtr)/2+1, rightPtr);
		TreeNode currNode = new TreeNode(currVal);
		currNode.left = leftNode;
		currNode.right = rightNode;
		return currNode;
	}
	
	public static TreeNode mySol(int[] nums) {
		if(nums.length == 0) {
			return null;
		}
		int rootVal = nums[nums.length/2];
		TreeNode root = new TreeNode(rootVal);
		helper(nums, 0, nums.length/2-1, root);
		helper(nums, nums.length/2+1, nums.length-1, root);
		return root;
	}
	
	public static void helper(int[] nums, int leftPtr, int rightPtr, TreeNode root) {
		if(leftPtr > rightPtr) {
			return;
		}
		TreeNode treePtr = root;
		int currVal = nums[(leftPtr + rightPtr)/2];
		while(true) {
			if(currVal < treePtr.val) {
				if(treePtr.left != null) {
					treePtr = treePtr.left;
					continue;
				}
				if(treePtr.left == null) {
					treePtr.left = new TreeNode(currVal);
					break;
				}
			}
			if(currVal > treePtr.val) {
				if(treePtr.right != null) {
					treePtr = treePtr.right;
					continue;
				}
				if(treePtr.right == null) {
					treePtr.right = new TreeNode(currVal);
					break;
				}
			}
			else {
				break;
			}
		}
		helper(nums, leftPtr, (leftPtr + rightPtr)/2-1, root);
		helper(nums, (leftPtr + rightPtr)/2+1, rightPtr, root);
	}
	
}
