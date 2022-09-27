package leetcode.medium;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left 
 * to bottom right, which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/minimum-path-sum/
 */

public class Minimum_Path_Sum {

	public static void main(String[] args) {
//		int[][] grid = {
//				{1,3,1},
//				{1,5,1},
//				{4,2,1}
//		};
		int[][] grid = {
				{1,2,3},
				{4,5,6}
		};
		System.out.println(mySol(grid));
	}
	
	public static int mySol(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		for(int i=1; i<dp.length; i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		for(int i=1; i<dp[0].length; i++) {
			dp[0][i] = dp[0][i-1] + grid[0][i];
		}
		for(int row=1; row<dp.length; row++) {
			for(int col=1; col<dp[row].length; col++) {
				dp[row][col] = dp[row-1][col] > dp[row][col-1] ? dp[row][col-1] : dp[row-1][col];
				dp[row][col] += grid[row][col];
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
}
