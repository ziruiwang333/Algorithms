package leetcode.topcode;

import leetcode.common.listNode.ListNode;

/**
 * @Description: 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 *  如果两个链表不存在相交节点，返回 null 。
 * @url: https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * @Date: 2022/10/10
 * @Author: Zirui Wang
 */
public class GetIntersectionNode_22_160 {
    /**
     * 获得两个链表的长度差，消除长度差获得第一个交叉点
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.16%的用户
     * 内存消耗：44.2 MB, 在所有 Java 提交中击败了75.88%的用户
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode aPtr = headA;
        ListNode bPtr = headB;
        int aLen = 0;
        int bLen = 0;
        while (aPtr != null || bPtr != null){
            if(aPtr != null){
                aPtr = aPtr.next;
                aLen++;
            }
            if(bPtr != null){
                bPtr = bPtr.next;
                bLen++;
            }
        }
        if(aLen > bLen){
            int temp = aLen - bLen;
            while (temp > 0){
                headA = headA.next;
                temp--;
            }
        } else {
            int temp = bLen - aLen;
            while (temp > 0){
                headB = headB.next;
                temp--;
            }
        }
        while (headA != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
