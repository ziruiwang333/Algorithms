package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.common.treeNode.TreeNode;

/**
 * Given the root of a binary tree, return the maximum width of the given tree.
 * 
 * The maximum width of a tree is the maximum width among all levels.
 * 
 * The width of one level is defined as the length between the end-nodes (the 
 * leftmost and rightmost non-null nodes), where the null nodes between the 
 * end-nodes are also counted into the length calculation.
 * 
 * It is guaranteed that the answer will in the range of 32-bit signed integer.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/maximum-width-of-binary-tree/
 */

public class Maximum_Width_of_Binary_Tree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
		System.out.println(mySol(root));
	}
	
	public static int mySol(TreeNode root) {
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		Queue<Integer> indexQueue = new LinkedList<>();
		nodeQueue.add(root);
		indexQueue.add(1);
		int result = 0;
		while(!nodeQueue.isEmpty()) {
			int levelSize = nodeQueue.size();
			int leftIdx = indexQueue.peek();
			int currIdx = 0;
			while(levelSize > 0) {
				TreeNode curr = nodeQueue.poll();
				currIdx = indexQueue.poll();
				if(curr.left != null) {
					nodeQueue.add(curr.left);
					indexQueue.add(2*currIdx);
				}
				if(curr.right != null) {
					nodeQueue.add(curr.right);
					indexQueue.add(2*currIdx+1);
				}
				levelSize--;
			}
			int width = currIdx - leftIdx + 1;
			if(width > result) {
				result = width;
			}
		}
		return result;
	}

}
