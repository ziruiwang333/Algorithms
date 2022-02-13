package leetcode.easy;

import leetcode.common.treeNode.TreeNode;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree 
 * has a root-to-leaf path such that adding up all the values along the path equals 
 * targetSum.
 * 
 * A leaf is a node with no children.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/path-sum/
 */

public class Path_Sum {

	public static void main(String[] args) {
		
	}
	
	public static boolean mySol(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}
		return helper(root, 0, targetSum);
	}
	
	public static boolean helper(TreeNode node, int currSum, int targetSum) {
		if(node.left == null && node.right == null) {
			return node.val + currSum == targetSum;
		}
		boolean checkLeft = false;
		boolean checkRight = false;
		if(node.left != null) {
			checkLeft = helper(node.left, currSum + node.val, targetSum);
		}
		if(node.right != null) {
			checkRight = helper(node.right, currSum + node.val, targetSum);
		}
		return checkLeft || checkRight;
	}

}
