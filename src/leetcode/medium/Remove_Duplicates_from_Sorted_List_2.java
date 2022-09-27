package leetcode.medium;

import leetcode.common.listNode.ListNode;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate 
 * numbers, leaving only distinct numbers from the original list. Return the 
 * linked list sorted as well.
 * 
 * @author ziruiwang
 * @url https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */

public class Remove_Duplicates_from_Sorted_List_2 {

	public static void main(String[] args) {
//		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
		ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
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
		ListNode result = null;
		ListNode resultPtr = result;
		if(head.val != head.next.val) {
			result = head;
			resultPtr = result;
		}
		
		ListNode pre = head;
		ListNode curr = head.next;
		ListNode next = head.next.next;
		
		while(next != null) {
			if(pre.val != curr.val && curr.val != next.val) {
				if(result == null) {
					result = curr;
					resultPtr = result;
				}
				else {
					resultPtr.next = curr;
					resultPtr = resultPtr.next;
				}
			}
			pre = curr;
			curr = next;
			next = next.next;
		}
		
		if(curr.val != pre.val) {
			if(result == null) {
				result = curr;
				resultPtr = result;
			} else {
				resultPtr.next = curr;
				resultPtr = resultPtr.next;
			}
		}
		if(resultPtr != null) {
			resultPtr.next = null;			
		}
		return result;
	}

}
