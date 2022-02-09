package leetcode.medium;

import leetcode.lib.listNode.ListNode;

/**
 * Given the head of a linked list, remove the nth node from the end of the list 
 * and return its head.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class Remove_Nth_Node_From_End_of_List {

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		ListNode result = mySol(head, 2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode mySol(ListNode head, int n) {
		if(head == null) {
			return null;
		}
		int counter = 0;
		ListNode nodePtr = head;
		while(nodePtr != null) {
			counter++;
			nodePtr = nodePtr.next;
		}
		
		int fromStart = counter - n + 1;
		if(fromStart == 1) {
			ListNode temp = head.next;
			head = null;
			return temp;
		}
		nodePtr = head;
		ListNode pre = null;
		for(int i=0; i<fromStart-2; i++) {
			nodePtr = nodePtr.next;
		}
		pre = nodePtr;
		nodePtr = nodePtr.next.next;
		pre.next = nodePtr;
		return head;
	}

}
