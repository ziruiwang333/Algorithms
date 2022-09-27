package leetcode.medium;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the 
 * diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot is
 *  trying to reach the bottom-right corner of the grid (marked 'Finish' in the 
 *  diagram below).
 *  
 *  Now consider if some obstacles are added to the grids. How many unique paths 
 *  would there be?
 *  
 *  An obstacle and space is marked as 1 and 0 respectively in the grid.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/unique-paths-ii/
 */

public class Unique_Path_2 {

	public static void main(String[] args) {
		int[][] obstacleGrid = {
				{0,0,1},
//				{0,1,0},
//				{0,0,0}
		};
		System.out.println(mySol(obstacleGrid));
	}
	
	public static int mySol(int[][] obstacleGrid) {
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
		for(int i=0; i<dp.length; i++) {
			if(obstacleGrid[i][0] == 1) {
				break;
			}
			dp[i][0] = 1;
		}
		for(int i=0; i<dp[0].length; i++) {
			if(obstacleGrid[0][i] == 1) {
				break;
			}
			dp[0][i] = 1;
		}
		for(int row=1; row<dp.length; row++) {
			for(int col=1; col<dp[row].length; col++) {
				if(obstacleGrid[row][col] == 1) {
					dp[row][col] = 0;
				}
				else {
					dp[row][col] = dp[row-1][col] + dp[row][col-1];
				}
			}
		}
		return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
	}

}
