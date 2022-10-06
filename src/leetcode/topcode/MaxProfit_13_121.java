package leetcode.topcode;

/**
 * @Description: 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *  你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *  返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @url: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * @Date: 2022/10/6
 * @Author: Zirui Wang
 */
public class MaxProfit_13_121 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 思路：遍历一遍数组，用 当天金额 - 截止当天为止金额最小的值
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：58 MB, 在所有 Java 提交中击败了15.02%的用户
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices){
        int currMin = Integer.MAX_VALUE;
        int result = 0;
        for(int i: prices){
            if(i < currMin){
                currMin = i;
            }
            if(i-currMin > result){
                result = i - currMin;
            }
        }
        return result;
    }
}
