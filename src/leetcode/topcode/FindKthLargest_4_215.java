package leetcode.topcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *  请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *  你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @url: https://leetcode.cn/problems/kth-largest-element-in-an-array/
 * @Date: 2022/10/2
 * @Author: Zirui Wang
 */
public class FindKthLargest_4_215 {
    public static void main(String[] args) {
        int[] nums = new int[]{8,3,2,1,5,6,4,0,8,5,3,3,5,6,8};
        System.out.println(findKthLargest2(nums, 2));
    }

    /**
     * 改进的快速排序
     * 执行用时：54 ms, 在所有 Java 提交中击败了17.51%的用户
     * 内存消耗：50.3 MB, 在所有 Java 提交中击败了13.70%的用户
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k){
        if(k > nums.length){
            return -1;
        }
        int targetIdx = nums.length - k;
        helper(nums, 0, nums.length-1, targetIdx);
        return nums[targetIdx];
    }
    static boolean flag = false;
    public static void helper(int[] nums, int start, int end, int targetIdx){
        if(start >= end){
            return;
        }
        int base = nums[start];
        int left = start;
        int right = end;
        while(left < right){
            if(nums[right] >= base){
                right--;
                continue;
            }
            if(nums[left] <= base){
                left++;
                continue;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        nums[start] = nums[left];
        nums[left] = base;
        if(left == targetIdx){
            flag = true;
            return;
        }
        if(flag == false){
            helper(nums, start, left-1, targetIdx);
            helper(nums, left+1, end, targetIdx);
        }
    }

    /**
     * 优先队列
     * 执行用时：56 ms, 在所有 Java 提交中击败了16.91%的用户
     * 内存消耗：50.9 MB, 在所有 Java 提交中击败了8.68%的用户
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k){
        if(k > nums.length){
            return -1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((i1, i2) -> i2-i1);
        for(int i: nums){
            priorityQueue.add(i);
        }
        while(priorityQueue.size() != (nums.length - k + 1)){
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
