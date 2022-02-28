package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row 
 * and column to 0's.
 * 
 * You must do it in place.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/set-matrix-zeroes/
 */

public class Set_Matrix_Zeroes {

	public static void main(String[] args) {
//		int[][] matrix = new int[][] {
//			{1,1,1},
//			{1,0,1},
//			{1,1,1}
//		};
		int[][] matrix = new int[][] {
			{0,1,2,0},
			{3,4,5,2},
			{1,3,1,5}
		};
		mySol(matrix);
		for(int[] i: matrix) {
			System.out.println(Arrays.toString(i));
		}
	}
	
	public static void mySol(int[][] matrix) {
		ArrayList<int[]> zeroList = new ArrayList<>();
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(matrix[i][j] == 0) {
					zeroList.add(new int[] {i, j});
				}
			}
		}
		Iterator<int[]> iterator = zeroList.iterator();
		while(iterator.hasNext()) {
			int[] currPos = iterator.next();
			for(int col=0; col<matrix[0].length; col++) {
				matrix[currPos[0]][col] = 0;
			}
			for(int row=0; row<matrix.length; row++) {
				matrix[row][currPos[1]] = 0;
			}
		}
	}

}
