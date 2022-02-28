package leetcode.medium;

/**
 * Write an efficient algorithm that searches for a value target in an m x n 
 * integer matrix matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous 
 * row.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/search-a-2d-matrix/
 */

public class Search_a_2D_Matrix {

	public static void main(String[] args) {
		int[][] matrix = {
				{1,3,5,7},
				{10,11,16,20},
				{23,30,34,60}
		};
		System.out.println(mySol(matrix, 13));
	}
	
	public static boolean mySol(int[][] matrix, int target) {
		for(int row=0; row<matrix.length; row++) {
			if(matrix[row][matrix[0].length-1] == target) {
				return true;
			}
			if(matrix[row][matrix[0].length-1] > target) {
				int left = 0;
				int right = matrix[0].length-1;
				while(left <= right) {
					int middle = (left + right) / 2;
					if(matrix[row][middle] == target) {
						return true;
					}
					if(matrix[row][middle] > target) {
						right = middle - 1;
						continue;
					}
					if(matrix[row][middle] < target) {
						left = middle + 1;
						continue;
					}
				}
				break;
			}
		}
		return false;
	}

}
