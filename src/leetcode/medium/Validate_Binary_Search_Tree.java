package leetcode.medium;

import leetcode.common.treeNode.TreeNode;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * A valid BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/validate-binary-search-tree/
 */

public class Validate_Binary_Search_Tree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(7, new TreeNode(6), new TreeNode(8)));
		System.out.println(mySol(root));
	}
	
	public static boolean mySol(TreeNode root) {
		if(root == null) {
			return false;
		}
		return helper(root.left, null, root.val) && helper(root.right, root.val, null);
	}
	
	public static boolean helper(TreeNode currNode, Integer lower, Integer upper) {
		if(currNode == null) {
			return true;
		}
		if (lower != null && upper != null) {
			return currNode.val > lower && currNode.val < upper && helper(currNode.left, lower, currNode.val)
					&& helper(currNode.right, currNode.val, upper);
		}
		if(lower == null && upper != null) {
			return currNode.val < upper && helper(currNode.left, lower, currNode.val) && helper(currNode.right, currNode.val, upper);
		}
		if(lower != null && upper == null) {
			return currNode.val > lower && helper(currNode.left, lower, currNode.val) && helper(currNode.right, currNode.val, upper);
		}
		return false;
	}
	
}
