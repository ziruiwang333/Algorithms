package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given an m x n grid of characters board and a string word, return true if word 
 * exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells, where
 * adjacent cells are horizontally or vertically neighboring. The same letter cell
 * may not be used more than once.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/word-search/
 */

public class Word_Search {

	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
//		char[][] board = {
//				{'A','A','A','A','A','A'},
//				{'A','A','A','A','A','A'},
//				{'A','A','A','A','A','A'},
//				{'A','A','A','A','A','A'},
//				{'A','A','A','A','A','A'},
//		};
		String word ="SEE";
		System.out.println(optimizedSol(board, word));
		System.out.println(mySol(board, word));
	}
	
	public static boolean optimizedSol(char[][] board, String word) {
		boolean result = false;
		for(int row=0; row<board.length; row++) {
			for(int col=0; col<board[0].length; col++) {
				if(result) {
					return true;
				}
				result = result || optimizedHelper(board, word, 0, new int[] {row,col}, new boolean[board.length][board[0].length]);
			}
		}
		return result;
	}
	
	public static boolean optimizedHelper(char[][] board, String word, int wordPtr, int[] currPos, boolean[][] searched) {
		if(wordPtr == word.length()) {
			return true;
		}
		if(currPos[0] < 0 || currPos[0] >= board.length) {
			return false;
		}
		if(currPos[1] < 0 || currPos[1] >= board[0].length) {
			return false;
		}
		if(searched[currPos[0]][currPos[1]]) {
			return false;
		}
		if(board[currPos[0]][currPos[1]] != word.charAt(wordPtr)) {
			return false;
		}
		searched[currPos[0]][currPos[1]] = true;
		boolean result = optimizedHelper(board, word, wordPtr+1, new int[] {currPos[0]-1, currPos[1]}, searched)
				|| optimizedHelper(board, word, wordPtr+1, new int[] {currPos[0]+1, currPos[1]}, searched)
				|| optimizedHelper(board, word, wordPtr+1, new int[] {currPos[0], currPos[1]-1}, searched)
				|| optimizedHelper(board, word, wordPtr+1, new int[] {currPos[0], currPos[1]+1}, searched);
		if(result) {
			return true;
		}
		searched[currPos[0]][currPos[1]] = false;
		return false;
	}

	
	//Time Limit Exceeded
	public static boolean mySol(char[][] board, String word) {
		boolean result = false;
		for(int row=0; row<board.length; row++) {
			for(int col=0; col<board[row].length; col++) {
				if(result == true) {
					break;
				}
				result = result || helper(board, word, 0, new int[] {row,col}, new ArrayList<>());
			}
		}
		return result;
	}
	
	public static boolean helper(char[][] board, String word, int wordPtr, int[] currPos, ArrayList<int[]> searched) {
		if(currPos[0] < 0 || currPos[0] > board.length-1) {
			return false;
		}
		if(currPos[1] < 0 || currPos[1] > board[0].length-1) {
			return false;
		}
		ArrayList<int[]> toSearch = new ArrayList<>();
		if(board[currPos[0]][currPos[1]] == word.charAt(wordPtr)) {
			if(wordPtr == word.length()-1) {
				return true;
			}
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(currPos[0]);
			toSearch.add(new int[] {currPos[0], currPos[1]-1});
			toSearch.add(new int[] {currPos[0], currPos[1]+1});
			toSearch.add(new int[] {currPos[0]-1, currPos[1]});
			toSearch.add(new int[] {currPos[0]+1, currPos[1]});
		}
		boolean result = false;
		out:for(int i=0; i<toSearch.size(); i++) {
			if(result == true) {
				break;
			}
			for(int j=0; j<searched.size(); j++) {
				if(Arrays.equals(searched.get(j), toSearch.get(i))) {
					continue out;
				}
			}
			ArrayList<int[]> temp = new ArrayList<>();
			temp.addAll(searched);
			temp.add(currPos);
			temp.add(toSearch.get(i));
			result = result || helper(board, word, wordPtr+1, toSearch.get(i), temp);
		}
		return result;
	}

}
