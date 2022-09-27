package leetcode.easy;

import leetcode.common.listNode.ListNode;

/**
 * Given head, the head of a linked list, determine if the linked list has a 
 * cycle in it.
 * 
 * There is a cycle in a linked list if there is some node in the list that can 
 * be reached again by continuously following the next pointer. Internally, pos 
 * is used to denote the index of the node that tail's next pointer is connected 
 * to. Note that pos is not passed as a parameter.
 * 
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/linked-list-cycle/
 */

public class Linked_List_Cycle {

	public static void main(String[] args) {
		ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(4))));
		head.next.next.next.next = head.next.next;
		System.out.println(mySol(head));
	}
	
	public static boolean mySol(ListNode head) {
		if(head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow != fast) {
			if(fast == null || fast.next == null) {
				return false;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return true;
	}

}
