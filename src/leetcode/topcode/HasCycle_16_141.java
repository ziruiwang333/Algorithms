package leetcode.topcode;

import leetcode.common.listNode.ListNode;

/**
 * @Description:
 * @Date: 2022/10/7
 * @Author: Zirui Wang
 */
public class HasCycle_16_141 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42.7 MB, 在所有 Java 提交中击败了39.24%的用户
     * @param head
     * @return
     */
    public static boolean isCycle(ListNode head){
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head.next.next;
        while (slowPtr != fastPtr){
            if(fastPtr.next != null && fastPtr.next.next != null){
                fastPtr = fastPtr.next.next;
                slowPtr = slowPtr.next;
                continue;
            }
            return false;
        }
        return true;
    }
}
