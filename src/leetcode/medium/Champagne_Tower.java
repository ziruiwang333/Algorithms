package leetcode.medium;

/**
 * 
 * @author zirui
 * @url https://leetcode.com/problems/champagne-tower/
 */

public class Champagne_Tower {

	public static void main(String[] args) {
		System.out.println(mySol(3, 1, 0));
	}
	
	public static double mySol(int poured, int query_row, int query_glass) {
		if(poured == 0) {
			return 0;
		}
		double[][] dp = new double[query_row+1+1][query_row+1+1];
		dp[0][0] = poured;
		for(int row=0; row<query_row+1; row++) {
			for(int col=0; col<row+1; col++) {
				if(dp[row][col] > 1) {
					dp[row+1][col] += (dp[row][col] - 1) / 2;
					dp[row+1][col+1] += (dp[row][col] - 1) / 2;
					dp[row][col] = 1;
				}
			}
		}
		return dp[query_row][query_glass];
	}

}
