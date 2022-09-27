package leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/spiral-matrix/
 */

public class Spiral_Matrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, };
//		int[][] matrix = { { 7 }, { 9 }, { 6 } };
		Iterator<Integer> iterator = mySol(matrix).iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public static List<Integer> mySol(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		int left = 0;
		int right = matrix[0].length - 1;
		int top = 0;
		int bottom = matrix.length - 1;
		int direction = 0;
		while (left <= right && top <= bottom) {
			if (direction == 0) {
				for(int i=left; i<=right; i++) {
					result.add(matrix[top][i]);
				}
				top++;
				direction = 1;
			}
			else if (direction == 1) {
				for(int i=top; i<=bottom; i++) {
					result.add(matrix[i][right]);
				}
				right--;
				direction = 2;
			}
			else if (direction == 2) {
				for(int i=right; i>=left; i--) {
					result.add(matrix[bottom][i]);
				}
				bottom--;
				direction = 3;
			}
			else if (direction == 3) {
				for(int i=bottom; i>=top; i--) {
					result.add(matrix[i][left]);
				}
				left++;
				direction = 0;
			}
		}
		return result;

	}
}
