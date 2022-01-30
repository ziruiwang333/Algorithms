package leetcode.easy;

import java.util.HashSet;

import leetcode.easy.listNode.ListNode;

/**
 * Given the head of a sorted linked list, delete all duplicates such that 
 * each element appears only once. Return the linked list sorted as well.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */

public class Remove_Duplicates_from_Sorted_List {

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3)))));
		ListNode result = mySol(head);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
	}
	
	public static ListNode mySol(ListNode head) {
		HashSet<Integer> hs = new HashSet<>();
		ListNode result = null;
		ListNode headPtr = head;
		ListNode resultPtr = null;
		while(headPtr != null) {
			if(hs.add(headPtr.val)) {
				if(result == null) {
					result = new ListNode(headPtr.val);
					resultPtr = result;
					continue;
				}
				resultPtr.next = new ListNode(headPtr.val);
				resultPtr = resultPtr.next;
			}
			headPtr = headPtr.next;
		}
		return result;
	}

}
