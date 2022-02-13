package leetcode.medium;

import java.util.HashSet;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be 
 * validated according to the following rules: 
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * 
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/valid-sudoku/
 */

public class Valid_Sudoku {

	public static void main(String[] args) {
		char[][] board = {
				{'.','.','4','.','.','.','6','3','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','9','.'},
				{'.','.','.','5','6','.','.','.','.'},
				{'4','.','3','.','.','.','.','.','1'},
				{'.','.','.','7','.','.','.','.','.'},
				{'.','.','.','5','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				};
		System.out.println(mySol(board));
	}
	
	public static boolean mySol(char[][] board) {
		HashSet<Character>[] columnSet = new HashSet[9];
		HashSet<Character>[] blockSet = new HashSet[9];
		for(int i=0; i<columnSet.length; i++) {
			columnSet[i] = new HashSet<Character>();
			blockSet[i] = new HashSet<Character>();
		}
		for(int i=0; i<board.length; i++) {
			HashSet<Character> rowSet = new HashSet<>();
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j] != '.') {
					if(rowSet.contains(board[i][j])) {
						return false;
					}
					if(columnSet[j].contains(board[i][j])) {
						return false;
					}
					int blockSetIdx = (i/3)*3 + j/3;
					if(blockSet[blockSetIdx].contains(board[i][j])) {
						return false;
					}
					rowSet.add(board[i][j]);
					columnSet[j].add(board[i][j]);
					blockSet[blockSetIdx].add(board[i][j]);
				}
			}
		}
		return true;
	}

}
