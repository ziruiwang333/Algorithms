package leetcode.medium;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 
 * 90 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the input 
 * 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/rotate-image/
 */

public class Rotate_Image {

	public static void main(String[] args) {
//		int[][] matrix = {
//				{1,2,3},
//				{4,5,6},
//				{7,8,9}};
		int[][] matrix = {
				{5,1,9,11},
				{2,4,8,10},
				{13,3,6,7},
				{15,14,12,16}
		};
		mySol(matrix);
		for(int[] i: matrix) {
			System.out.println(Arrays.toString(i));
		}
	}
	
	public static void mySol(int[][] matrix) {
		for(int row=0; row<(matrix.length)/2; row++) {
			for(int col=row; col<matrix[row].length-1-row; col++) {
				for(int i=0; i<3; i++) {
					int temp = matrix[row][col];
					if(i == 0) {
						matrix[row][col] = matrix[col][matrix.length-1-row];
						matrix[col][matrix.length-1-row] = temp;
					}
					else if(i == 1) {
						matrix[row][col] = matrix[matrix.length-1-row][matrix.length-1-col];
						matrix[matrix.length-1-row][matrix.length-1-col] = temp;
					}
					else if(i == 2) {
						matrix[row][col] = matrix[matrix.length-1-col][row];
						matrix[matrix.length-1-col][row] = temp;
					}
				}
			}
		}
	}

}
