package leetcode.medium;

import leetcode.easy.listNode.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/add-two-numbers/
 */

public class Add_Two_Numbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9)));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
		ListNode result = mySol(l1, l2);
		while(result!=null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode mySol(ListNode l1, ListNode l2) {
		ListNode l1Ptr = l1;
		ListNode l2Ptr = l2;
		ListNode result = null;
		ListNode resultPtr = result;
		int carry = 0;
		while(l1Ptr != null || l2Ptr != null) {
			int l1Val = 0, l2Val = 0, temp = 0;
			if(l1Ptr != null) {
				l1Val = l1Ptr.val;
				l1Ptr = l1Ptr.next;
			}
			if(l2Ptr != null) {
				l2Val = l2Ptr.val;
				l2Ptr = l2Ptr.next;
			}
			temp = l1Val + l2Val + carry;
			if(result==null) {
				result = new ListNode(temp%10);
				resultPtr = result;
			} else {
				resultPtr.next = new ListNode(temp%10);
				resultPtr = resultPtr.next;
			}
			carry = temp / 10;
		}
		
		if(carry != 0) {
			resultPtr.next = new ListNode(carry);
		}
		
		return result;
	}

}
