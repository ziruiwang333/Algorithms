package leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import leetcode.common.treeNode.TreeNode;

public class Binary_Tree_Zigzag_Level_Order_Traversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		Iterator<List<Integer>> iterator = mySol(root).iterator();
		while(iterator.hasNext()) {
			List<Integer> next = iterator.next();
			System.out.println(next);
		}
	}
	
	public static List<List<Integer>> mySol(TreeNode root){
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Stack<TreeNode> stack1 = new Stack<>();
		stack1.add(root);
		Stack<TreeNode> stack2 = new Stack<>();
		int direction = 0;
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			List<Integer> element = new ArrayList<>();
			Stack<TreeNode> currStack = direction == 0 ? stack1 : stack2;
			int size = currStack.size();
			for(int i=0; i<size; i++) {
				TreeNode currNode = currStack.pop();
				element.add(currNode.val);
				if(direction == 0) {
					if(currNode.left != null)
						stack2.add(currNode.left);
					if(currNode.right != null)
						stack2.add(currNode.right);
				}
				else {
					if(currNode.right != null)
						stack1.add(currNode.right);
					if(currNode.left != null)
						stack1.add(currNode.left);
				}
			}
			result.add(element);
			direction = direction == 0 ? 1 : 0;
		}
		return result;
	}
}
