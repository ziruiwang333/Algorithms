package leetcode.topcode;

import java.util.Arrays;

/**
 * @Description: 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
 * 分别表示 nums1 和 nums2 中的元素数目。
 *  请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *  注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 *  其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * @url: https://leetcode.cn/problems/merge-sorted-array/
 * @Date: 2022/10/8
 * @Author: Zirui Wang
 */
public class Merge_17_88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.2 MB, 在所有 Java 提交中击败了85.01%的用户
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        if(n == 0){
            return;
        }
        int nums1Ptr = m-1;
        int nums2Ptr = n-1;
        int nums1ArrPtr = nums1.length-1;
        while (nums1ArrPtr != -1){
            if(nums1Ptr == -1){
                nums1[nums1ArrPtr] = nums2[nums2Ptr];
                nums2Ptr--;
                nums1ArrPtr--;
                continue;
            }
            if(nums2Ptr == -1){
                nums1[nums1ArrPtr] = nums1[nums1Ptr];
                nums1Ptr--;
                nums1ArrPtr--;
                continue;
            }
            if(nums1[nums1Ptr] > nums2[nums2Ptr]) {
                nums1[nums1ArrPtr] = nums1[nums1Ptr];
                nums1Ptr--;
                nums1ArrPtr--;
                continue;
            }
            if(nums1[nums1Ptr] <= nums2[nums2Ptr]){
                nums1[nums1ArrPtr] = nums2[nums2Ptr];
                nums2Ptr--;
                nums1ArrPtr--;
            }
        }
    }
}
