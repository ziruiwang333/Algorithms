package leetcode.medium;

import leetcode.common.listNode.ListNode;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/rotate-list/
 */

public class Rotate_List {

	public static void main(String[] args) {
		ListNode head = new ListNode(0, new ListNode(1, new ListNode(2)));
		ListNode result = mySol(head, 2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode mySol(ListNode head, int k) {
		if(head == null) {
			return null;
		}
		int listLen = 0;
		ListNode headPtr = head;
		ListNode tail = null;
		while(headPtr != null) {
			tail = headPtr;
			headPtr = headPtr.next;
			listLen++;
		}
		int rotateLen = k % listLen;
		if(rotateLen == 0) {
			return head;
		}
		headPtr = head;
		for(int i=0; i<listLen-rotateLen-1; i++) {
			headPtr = headPtr.next;
		}
		ListNode result = headPtr.next;
		headPtr.next = null;
		tail.next = head;
		return result;
	}

}
