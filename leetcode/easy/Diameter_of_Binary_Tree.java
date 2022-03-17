package leetcode.easy;

import leetcode.common.treeNode.TreeNode;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * 
 * The diameter of a binary tree is the length of the longest path between any two
 * nodes in a tree. This path may or may not pass through the root.
 * 
 * The length of a path between two nodes is represented by the number of edges
 * between them.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/diameter-of-binary-tree/
 */

public class Diameter_of_Binary_Tree {
	
	static int result = 0;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(1));
		root = new TreeNode(1, new TreeNode(2), null);
		System.out.println(mySol(root));
	}
	
	public static int mySol(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftDepth = mySol(root.left);
		int rightDepth = mySol(root.right);
		result = result > leftDepth + rightDepth ? result : leftDepth + rightDepth;
		return leftDepth > rightDepth ? leftDepth+1 : rightDepth+1;
	}

}
