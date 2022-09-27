package leetcode.easy;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct 
 * ways can you climb to the top?
 * 
 * @author zirui
 * @url https://leetcode.com/problems/climbing-stairs/
 */

public class Climbing_Stairs {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(mySol(n));
	}
	
	public static int mySol(int n) {
		if(n == 1) {
			return 1;
		}
		int[] steps = new int[n];
		steps[0] = 1;
		steps[1] = 2;
		for(int i=2; i<n; i++) {
			steps[i] = steps[i-1] + steps[i-2];
		}
		return steps[n-1];
	}

}
