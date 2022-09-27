package leetcode.easy;

import leetcode.common.listNode.ListNode;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/merge-two-sorted-lists/
 */

public class Merge_Two_Sorted_List {

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		ListNode result = mySol(list1, list2);
		while(result!=null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode mySol(ListNode list1, ListNode list2) {
		if(list1 == null) {
			return list2;
		}
		if(list2 == null) {
			return list1;
		}
		
		ListNode result = null;
		ListNode list1Ptr = list1;
		ListNode list2Ptr = list2;
		ListNode resultPtr = null;
		
		while(list1Ptr != null && list2Ptr != null) {
			if(list1Ptr.val < list2Ptr.val) {
				if(result == null) {
					result = new ListNode(list1Ptr.val);
					list1Ptr = list1Ptr.next;
					resultPtr = result;
					continue;
				}
				resultPtr.next = new ListNode(list1Ptr.val);
				resultPtr = resultPtr.next;
				list1Ptr = list1Ptr.next;
				continue;
			}
			if(result == null) {
				result = new ListNode(list2Ptr.val);
				list2Ptr = list2Ptr.next;
				resultPtr = result;
				continue;
			}
			resultPtr.next = new ListNode(list2Ptr.val);
			resultPtr = resultPtr.next;
			list2Ptr = list2Ptr.next;
		}
		
		if(list1Ptr == null && list2Ptr != null) {
			resultPtr.next = list2Ptr;
		}
		
		if(list2Ptr == null && list1Ptr != null) {
			resultPtr.next = list1Ptr;
		}
		
		
		return result;
	}

}
