package leetcode.topcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，
 *  并返回它们的数组下标。
 *  你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *  你可以按任意顺序返回答案。
 * @url: https://leetcode.cn/problems/two-sum/
 * @Date: 2022/10/5
 * @Author: Zirui Wang
 */
public class TwoSum_10_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.68%的用户
     * 内存消耗：41.7 MB, 在所有 Java 提交中击败了37.89%的用户
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int checkKey = target - nums[i];
            if(hashMap.containsKey(checkKey)){
                return new int[]{i, hashMap.get(checkKey)};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }

    /**
     * 暴力解法
     * 执行用时：56 ms, 在所有 Java 提交中击败了16.62%的用户
     * 内存消耗：42.1 MB, 在所有 Java 提交中击败了10.20%的用户
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target){
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j< nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
