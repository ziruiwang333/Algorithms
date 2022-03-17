package leetcode.medium;

import leetcode.common.listNode.ListNode;

/**
 * Given the head of a singly linked list and two integers left and right where 
 * left <= right, reverse the nodes of the list from position left to position 
 * right, and return the reversed list.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/reverse-linked-list-ii/
 */

public class Reverse_Linked_List_2 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		ListNode result = mySol(head, 2, 4);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode mySol(ListNode head, int left, int right) {
		if(left == right) {
			return head;
		}
		ListNode headPtr = head;
		ListNode pre = null;
		ListNode leftPtr = null;
//		ListNode rightPtr = null;
		ListNode after = null;
		int counter = 1;
		while(counter <= right) {
			if(counter+1 == left) {
				pre = headPtr;
			}
			if(counter == left) {
				leftPtr = headPtr;
			}
			if(counter == right) {
//				rightPtr = headPtr;
				after = headPtr.next;
			}
			counter++;
			headPtr = headPtr.next;
		}
		for(int i=0; i<=right-left; i++) {
			ListNode currNode = leftPtr;
			leftPtr = leftPtr.next;
			currNode.next = after;
			after = currNode;
		}
		if(pre != null) {
			pre.next = after;
			return head;
		}
		return after;
	}

}
