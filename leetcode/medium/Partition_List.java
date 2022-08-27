package leetcode.medium;

import leetcode.common.listNode.ListNode;

/**
 * Given the head of a linked list and a value x, partition it such that all nodes 
 * less than x come before nodes greater than or equal to x.You should preserve the 
 * original relative order of the nodes in each of the two partitions.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/partition-list/
 *
 */

public class Partition_List {

	public static void main(String[] args) {
//		ListNode listNode = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
		ListNode listNode = new ListNode(2, new ListNode(1));
		ListNode result = mySol(listNode, 2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode mySol(ListNode head, int x) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode lessList = new ListNode();
		ListNode greaterList = new ListNode();
		ListNode lessPtr = lessList;
		ListNode greaterPtr = greaterList;
		ListNode headPtr = head;
		while(headPtr != null) {
			if(headPtr.val < x) {
				lessPtr.next = headPtr;
				headPtr = headPtr.next;
				lessPtr = lessPtr.next;
				lessPtr.next = null;
			} else {
				greaterPtr.next = headPtr;
				headPtr = headPtr.next;
				greaterPtr = greaterPtr.next;
				greaterPtr.next = null;
			}
		}
		ListNode result = lessList.next;
		if(result != null) {
			lessPtr.next = greaterList.next;
		} else {
			result = greaterList.next;
		}
		return result;
	}

}
