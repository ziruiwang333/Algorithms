package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.easy.treeNode.TreeNode;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 * 
 * @author zirui
 * @url https://leetcode.com/problems/symmetric-tree/
 */

public class Symmetric_Tree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)),
				new TreeNode(2, null, new TreeNode(3)));
		System.out.println(mySol(root));
	}

	public static boolean mySol(TreeNode root) {
		if (root == null) {
			return false;
		}
		if (root.left == null || root.right == null) {
			return root.left == root.right;
		}
		Queue<Integer> q = new LinkedList<>();
		addQueue(q, root.left);
		boolean result = isSymmetric(true, q, root.right);
		q.poll();
		return result && q.poll() == null;
	}

	public static void addQueue(Queue<Integer> q, TreeNode node) {
		q.add(node.val);
		if (node.left != null) {
			addQueue(q, node.left);
		} else {
			q.add(0);
		}
		if (node.right != null) {
			addQueue(q, node.right);
		} else {
			q.add(0);
		}
	}

	public static boolean isSymmetric(boolean isSym, Queue<Integer> q, TreeNode node) {
		System.out.println(1);
		if (q.poll() != node.val) {
			return false;
		}
		if (isSym) {
			if (node.right != null) {
				isSym = isSymmetric(isSym, q, node.right);
			} else {
				if (q.poll() != 0) {
					return false;
				}
			}
		}

		if (isSym) {
			if (isSym && node.left != null) {
				isSym = isSymmetric(isSym, q, node.left);
			} else {
				if (q.poll() != 0) {
					return false;
				}
			}
		}
		return isSym;
	}

}
