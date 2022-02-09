package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

import leetcode.lib.treeNode.TreeNode;

/**
 * Given the root of a binary tree, return the 
 * inorder traversal of its nodes' values.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

public class Binary_Tree_Inorder_Traversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
		List<Integer> result = mySol(root);
		for(Integer val: result) {
			System.out.println(val);
		}
	}
	
	public static List<Integer> mySol(TreeNode root){
		if(root == null) {
			return new LinkedList<Integer>();
		}
		List<Integer> result = new LinkedList<>();
		getInorderTraversal(result, root);
		return result;
	}
	
	public static void getInorderTraversal(List<Integer> result, TreeNode root) {
		if(root.left!=null) {
			getInorderTraversal(result, root.left);
		}
		result.add(root.val);
		if(root.right!=null) {
			getInorderTraversal(result, root.right);
		}
	}
}
