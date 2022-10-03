package leetcode.topcode;

import leetcode.common.listNode.ListNode;

import java.util.Stack;

/**
 * @Description: 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
 *  k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *  你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @url: https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * @Date: 2022/10/3
 * @Author: Zirui Wang
 */
public class ReverseKGroup_5_25 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = reverseKGroup3(head, 2);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了12.00%的用户
     * 改进2
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup3(ListNode head, int k){
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = new ListNode();
        result.next = head;
        ListNode preNode = result;
        ListNode postNode = null;
        ListNode startNode = head;
        ListNode endNode = head;
        int count = 1;
        while(endNode != null){
            if(count != k){
                endNode = endNode.next;
                count++;
                continue;
            }
            postNode = endNode.next;
            reverse(preNode, startNode, endNode, postNode);
            preNode = startNode;
            startNode = postNode;
            endNode = postNode;
            count = 1;
        }
        return result.next;
    }
    public static void reverse(ListNode preNode, ListNode startNode, ListNode endNode, ListNode postNode){
        ListNode tempNode = postNode;
        ListNode nextNode = startNode;
        while(nextNode != endNode){
            startNode = nextNode;
            nextNode = nextNode.next;
            startNode.next = tempNode;
            tempNode = startNode;
        }
        nextNode.next = tempNode;
        preNode.next = nextNode;
    }

    /**
     * 不使用栈
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.3 MB, 在所有 Java 提交中击败了36.73%的用户
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup2(ListNode head, int k){
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = new ListNode();
        result.next = head;
        ListNode preNode = result;
        ListNode postNode = null;
        ListNode startNode = head;
        ListNode endNode = head;
        int count = 1;
        while(endNode != null){
            if(count != k){
                endNode = endNode.next;
                count++;
                continue;
            }
            postNode = endNode.next;
            ListNode nextNode = startNode;
            ListNode tempNode = postNode;
            ListNode tempPreNode = startNode;
            while(nextNode != endNode){
                startNode = nextNode;
                nextNode = nextNode.next;
                startNode.next = tempNode;
                tempNode = startNode;
            }
            nextNode.next = tempNode;
            preNode.next = nextNode;
            preNode = tempPreNode;
            startNode = postNode;
            endNode = postNode;
            count = 1;
        }
        return result.next;
    }

        /**
         * 使用栈
         * 执行用时：3 ms, 在所有 Java 提交中击败了6.95%的用户
         * 内存消耗：41.3 MB, 在所有 Java 提交中击败了33.54%的用户
         * @param head
         * @param k
         * @return
         */
    public static ListNode reverseKGroup(ListNode head, int k){
        if(head == null || head.next == null){
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode headPtr = head;
        ListNode result = null;
        ListNode resultPtr = null;
        while(headPtr != null){
            stack.push(headPtr);
            headPtr = headPtr.next;
            if(stack.size() != k){
                continue;
            }
            if(result == null){
                result = stack.pop();
                resultPtr = result;
                resultPtr.next = null;
            }
            while (!stack.empty()){
                resultPtr.next = stack.pop();
                resultPtr = resultPtr.next;
                resultPtr.next = null;
            }
        }
        while(stack.size() >= 1){
            if(stack.size() == 1){
                resultPtr.next = stack.pop();
            } else {
                stack.pop();
            }
        }
        return result;
    }
}
