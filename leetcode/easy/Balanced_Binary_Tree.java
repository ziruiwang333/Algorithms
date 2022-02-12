package leetcode.easy;

import leetcode.common.treeNode.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in 
 * height by no more than 1.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/balanced-binary-tree/
 */

public class Balanced_Binary_Tree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
		System.out.println(mySol(root));
	}
	
	public static boolean mySol(TreeNode root) {
		if(root == null) {
			return true;
		}
		int leftDepth = helper(root.left);
		int rightDepth = helper(root.right);
		boolean result1 = Math.abs(leftDepth - rightDepth) <= 1;
		boolean result2 = mySol(root.left);
		boolean result3 = mySol(root.right);
		return result1 && result2 && result3;
	}
	
	public static int helper(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int leftDepth = helper(node.left) + 1;
		int rightDepth = helper(node.right) + 1;
		return leftDepth > rightDepth ? leftDepth : rightDepth;
	}

}
