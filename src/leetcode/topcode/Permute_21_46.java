package leetcode.topcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @url: https://leetcode.cn/problems/permutations/
 * @Date: 2022/10/10
 * @Author: Zirui Wang
 */
public class Permute_21_46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3,4,5}));
    }
    static List<List<Integer>> result = new ArrayList<>();

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.9 MB, 在所有 Java 提交中击败了22.84%的用户
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums){
        dfs(nums, new boolean[nums.length], new ArrayList<>());
        return result;
    }
    public static void dfs(int[] nums, boolean[] checked, List<Integer> temp){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(checked[i]){
                continue;
            }
            checked[i] = true;
            temp.add(nums[i]);
            dfs(nums, checked, temp);
            checked[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}
