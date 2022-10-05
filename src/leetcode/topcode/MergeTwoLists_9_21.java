package leetcode.topcode;

import leetcode.common.listNode.ListNode;

/**
 * @Description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @url: https://leetcode.cn/problems/merge-two-sorted-lists/
 * @Date: 2022/10/5
 * @Author: Zirui Wang
 */
public class MergeTwoLists_9_21 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = mergeTwoLists(list1, list2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.7 MB, 在所有 Java 提交中击败了88.20%的用户
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode result = new ListNode();
        ListNode resultPtr = result;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                resultPtr.next = list1;
                resultPtr = resultPtr.next;
                list1 = list1.next;
                continue;
            }
            resultPtr.next = list2;
            resultPtr = resultPtr.next;
            list2 = list2.next;
        }
        if(list1 != null){
            resultPtr.next = list1;
        } else {
            resultPtr.next = list2;
        }
        return result.next;
    }
}
