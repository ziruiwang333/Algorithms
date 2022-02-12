package leetcode.easy;

import leetcode.common.treeNode.TreeNode;

/**
 * Given the roots of two binary trees p and q, write a function to check if
 * they are the same or not. Two binary trees are considered the same if they
 * are structurally identical, and the nodes have the same value.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/same-tree/
 */

public class Same_Tree {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1, new TreeNode(1), null);
		TreeNode q = new TreeNode(1, new TreeNode(2), null);
		System.out.println(mySol(p, q));
	}

	public static boolean mySol(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return p == q;
		}
		return checkSame(true, p, q);
	}

	public static boolean checkSame(boolean isSame, TreeNode p, TreeNode q) {
		if (p.val != q.val) {
			return false;
		}

		if (isSame) {
			if (p.left != null && q.left != null) {
				isSame = checkSame(isSame, p.left, q.left);
			} else {
				isSame = p.left == q.left;
			}
		}

		if (isSame) {
			if (isSame && p.right != null && q.right != null) {
				isSame = checkSame(isSame, p.right, q.right);
			} else {
				isSame = p.right == q.right;
			}
		}

		return isSame;
	}

}
