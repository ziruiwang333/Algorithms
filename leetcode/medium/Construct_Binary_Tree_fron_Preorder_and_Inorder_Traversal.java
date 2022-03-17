package leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import leetcode.common.treeNode.TreeNode;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder 
 * traversal of a binary tree and inorder is the inorder traversal of the same 
 * tree, construct and return the binary tree.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

public class Construct_Binary_Tree_fron_Preorder_and_Inorder_Traversal {
	
	static HashSet<Integer> hs = new HashSet<>();

	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode result = mySol(preorder, inorder);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(result);
		while(!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			System.out.println(curr.val);
			if(curr.left != null) {
				queue.add(curr.left);
			}
			if(curr.right != null) {
				queue.add(curr.right);
			}
		}
	}
	
	public static TreeNode mySol(int[] preorder, int[] inorder) {
		TreeNode result = new TreeNode(preorder[0]);
		if(preorder.length == 1) {
			return result;
		}
		return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
	}
	
	public static TreeNode helper(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
		if(preLeft > preRight || inLeft > inRight) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preLeft]);
		int i = 0;
		while(preorder[preLeft] != inorder[i]) {
			i++;
		}
		root.left = helper(preorder, inorder, preLeft+1, i - inLeft + preLeft, inLeft, i-1);
		root.right = helper(preorder, inorder, i - inLeft + preLeft + 1, preRight, i+1, inRight);
		return root;
	}
}
