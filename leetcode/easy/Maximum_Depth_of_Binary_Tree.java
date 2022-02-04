package leetcode.easy;

import leetcode.easy.treeNode.TreeNode;

/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */

public class Maximum_Depth_of_Binary_Tree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
		System.out.println(mySol(root));
	}
	
	public static int mySol(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return getDepth(root);
	}
	
	public static int getDepth(TreeNode node) {
		if(node.left==null && node.right==null) {
			return 1;
		}
		int leftDepth=0;
		int rightDepth=0;
		if(node.left != null) {
			leftDepth = getDepth(node.left)+1;
		}
		if(node.right != null) {
			rightDepth = getDepth(node.right)+1;
		}
		return leftDepth>rightDepth?leftDepth:rightDepth;
	}

}
