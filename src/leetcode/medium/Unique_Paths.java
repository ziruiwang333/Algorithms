package leetcode.medium;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left 
 * corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner 
 * (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any 
 * point in time.
 * 
 * Given the two integers m and n, return the number of possible unique paths that 
 * the robot can take to reach the bottom-right corner.
 * 
 * The test cases are generated so that the answer will be less than or equal to 
 * 2 * 109.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/unique-paths/
 */

public class Unique_Paths {

	public static void main(String[] args) {
		int m = 1;
		int n = 1;
		System.out.println(mySol(m, n));
		System.out.println(optimizedSol(m, n));
	}
	
	//Dynamic Programming
	public static int optimizedSol(int m, int n) {
		int[][] dp = new int[m][n];
		for(int i=0; i<m; i++) {
			dp[i][0] = 1;
		}
		for(int i=0; i<n; i++) {
			dp[0][i] = 1;
		}
		for(int row=1; row<m; row++) {
			for(int col=1; col<n; col++) {
				dp[row][col] = dp[row-1][col] + dp[row][col-1];
			}
		}
		return dp[m-1][n-1];
	}
	
	// Time Limit Exceeded
	public static int mySol(int m, int n) {
		return helper(new int[] {m-1, n-1}, new int[] {0,0});
	}
	
	public static int helper(int[] dest, int[] currPos) {
		if(currPos[0] == dest[0] && currPos[1] == dest[1]) {
			return 1;
		}
		if(currPos[0] == dest[0]) {
			return helper(dest, new int[] {currPos[0], currPos[1]+1});
		}
		if(currPos[1] == dest[1]) {
			return helper(dest, new int[] {currPos[0]+1, currPos[1]});
		}
		return helper(dest, new int[] {currPos[0], currPos[1]+1}) + helper(dest, new int[] {currPos[0]+1, currPos[1]});
	}

}
