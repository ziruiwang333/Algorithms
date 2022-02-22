package leetcode.medium;

import java.util.Arrays;

/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/spiral-matrix-ii/
 */

public class Spiral_Matrix_2 {

	public static void main(String[] args) {
		int n = 1;
		int[][] result = mySol(n);
		for(int[] i: result) {
			System.out.println(Arrays.toString(i));
		}
	}
	
	public static int[][] mySol(int n){
		int[][] result = new int[n][n];
		int top = 0;
		int bottom = n-1;
		int left = 0;
		int right = n-1;
		int direction = 0;
		int count = 1;
		while(top <= bottom && left <= right) {
			if(direction == 0) {
				for(int i=left; i<=right; i++) {
					result[top][i] = count++;
				}
				direction = 1;
				top++;
			}
			else if(direction == 1) {
				for(int i=top; i<=bottom; i++) {
					result[i][right] = count++;
				}
				direction = 2;
				right--;
			}
			else if(direction == 2) {
				for(int i=right; i>=left; i--) {
					result[bottom][i] = count++;
				}
				direction = 3;
				bottom--;
			}
			else if(direction == 3) {
				for(int i=bottom; i>=top; i--) {
					result[i][left] = count++;
				}
				direction = 0;
				left++;
			}
		}
		return result;
	}

}
