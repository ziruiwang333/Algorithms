package leetcode.easy;

import leetcode.common.treeNode.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the root 
 * node down to the nearest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * @author zirui
 *
 */

public class Minimum_Depth_of_Binary_Tree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3, null, new TreeNode(20, null, new TreeNode(7)));
		root = new TreeNode(3, new TreeNode(9), new TreeNode(20, null, new TreeNode(7)));
		root = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));
		System.out.println(mySol(root));
	}
	
	public static int mySol(TreeNode root) {
		int result = 0;
		if(root == null) {
			return result;
		}
		return helper(root);
	}
	
	public static int helper(TreeNode node) {
		if(node.left == null && node.right == null) {
			return 1;
		}
		int leftDepth = 0;
		int rightDepth = 0;
		if(node.left != null) {
			leftDepth = helper(node.left) + 1;
		}
		if(node.right != null) {
			rightDepth = helper(node.right) + 1;
		}
		if(leftDepth == 0) {
			return rightDepth;
		}
		if(rightDepth == 0) {
			return leftDepth;
		}
		return leftDepth > rightDepth ? rightDepth : leftDepth;
	}

}
