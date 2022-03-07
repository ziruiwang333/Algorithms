package leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.common.treeNode.TreeNode;

/**
 * Given the root of a binary tree, return the level order traversal of its 
 * nodes' values. (i.e., from left to right, level by level).
 * 
 * @author zirui
 * @url https://leetcode.com/problems/binary-tree-level-order-traversal/
 */

public class Binary_Tree_Level_Order_Traversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		Iterator<List<Integer>> iterator = mySol(root).iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public static List<List<Integer>> mySol(TreeNode root){
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) {
			return null;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int currNodes = 1;
		while(!q.isEmpty()) {
			List<Integer> element = new ArrayList<>();
			int temp = 0;
			for(int i=0; i<currNodes; i++) {
				TreeNode currNode = q.poll();
				element.add(currNode.val);
				if(currNode.left != null) {
					q.add(currNode.left);
					temp++;
				}
				if(currNode.right != null) {
					q.add(currNode.right);
					temp++;
				}
			}
			result.add(element);
			currNodes = temp;
		}
		return result;
	}

}
