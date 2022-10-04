package leetcode.topcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 *  满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 *  请你返回所有和为 0 且不重复的三元组。
 *  注意：答案中不可以包含重复的三元组。
 * @url: https://leetcode.cn/problems/3sum/
 * @Date: 2022/10/4
 * @Author: Zirui Wang
 */
public class ThreeSum_6_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,1,1,2};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }

    /**
     * 双指针
     * 执行用时：24 ms, 在所有 Java 提交中击败了35.85%的用户
     * 内存消耗：45.6 MB, 在所有 Java 提交中击败了54.36%的用户
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] > 0){
                break;
            }
            int target = -nums[i];
            int leftPtr = i+1;
            int rightPtr = nums.length-1;
            while (leftPtr < rightPtr){
                if(leftPtr-1 != i && nums[leftPtr] == nums[leftPtr-1]){
                    leftPtr++;
                    continue;
                }
                if(rightPtr+1 != nums.length && nums[rightPtr] == nums[rightPtr+1]){
                    rightPtr--;
                    continue;
                }
                if(nums[leftPtr] + nums[rightPtr] == target){
                    result.add(Arrays.asList(nums[i], nums[leftPtr], nums[rightPtr]));
                    leftPtr++;
                    rightPtr--;
                    continue;
                }
                if(nums[leftPtr] + nums[rightPtr] < target){
                    leftPtr++;
                    continue;
                }
                if(nums[leftPtr] + nums[rightPtr] > target){
                    rightPtr--;
                    continue;
                }
            }
        }
        return result;
    }
}
