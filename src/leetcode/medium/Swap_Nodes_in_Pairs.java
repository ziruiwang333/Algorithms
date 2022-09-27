package leetcode.medium;

import leetcode.common.listNode.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. 
 * You must solve the problem without modifying the values in the list's nodes 
 * (i.e., only nodes themselves may be changed.)
 * 
 * @author zirui
 * @url https://leetcode.com/problems/swap-nodes-in-pairs/
 */

public class Swap_Nodes_in_Pairs {

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		ListNode result = mySol(head);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode mySol(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode nodePtr = head;
		ListNode result = null;
		ListNode pre = null;
		while(nodePtr != null && nodePtr.next != null) {
			ListNode currNode = nodePtr;
			ListNode nextNode = nodePtr.next;
			ListNode remainNodes = nodePtr.next.next;
			if(pre != null) {
				pre.next = nextNode;
			}
			nextNode.next = currNode;
			currNode.next = remainNodes;
			if(result == null) {
				result = nextNode;
			}
			nodePtr = remainNodes;
			pre = currNode;
		}
		return result;
	}

}
