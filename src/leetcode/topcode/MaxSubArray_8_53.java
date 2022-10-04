package leetcode.topcode;

import java.util.Arrays;

/**
 * @Description: 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *  子数组 是数组中的一个连续部分。
 * @url: https://leetcode.cn/problems/maximum-subarray/
 * @Date: 2022/10/4
 * @Author: Zirui Wang
 */
public class MaxSubArray_8_53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了41.31%的用户
     * 内存消耗：51.4 MB, 在所有 Java 提交中击败了5.05%的用户
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1; i<dp.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
        }
//        int result = Arrays.stream(dp).max().getAsInt();
        int result = dp[0];
        for (int i = 1; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
