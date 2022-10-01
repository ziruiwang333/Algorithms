package leetcode.topcode;

import leetcode.common.listNode.ListNode;

import java.util.Stack;

/**
 * @Description: 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @url: https://leetcode.cn/problems/reverse-linked-list/
 * @Date: 2022/10/1
 * @Author: Zirui Wang
 */
public class ReverseList_2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = reverseList(head);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 执行用时：1ms,在所有Java提交中击败了100.00%的用户
     * 内存消耗：41MB,在所有Java提交中击败了87.80%的用户
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            ListNode curr = head;
            head = head.next;
            curr.next = null;
            stack.push(curr);
        }
        ListNode result = stack.pop();
        ListNode resultPtr = result;
        while(stack.size() != 0){
            resultPtr.next = stack.pop();
            resultPtr = resultPtr.next;
        }
        return result;
    }
}
