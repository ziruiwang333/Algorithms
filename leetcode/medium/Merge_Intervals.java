package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all 
 * overlapping intervals, and return an array of the non-overlapping intervals 
 * that cover all the intervals in the input.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/merge-intervals/
 */

public class Merge_Intervals {

	public static void main(String[] args) {
		int[][] intervals = {
				{1,3},
				{2,6},
				{8,10},
				{10,18}
		};
//		int[][] intervals = {
//				{1,4},
//				{4,5},
//				{2,3}
//		};
		int[][] result = mySol(intervals);
		for(int[] i: result) {
			System.out.println(Arrays.toString(i));
		}
	}
	
	public static int[][] mySol(int[][] intervals){
		if(intervals.length == 1) {
			return intervals;
		}
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] > o2[0]) {
					return 1;
				}
				if(o1[0] < o2[0]) {
					return -1;
				}
				return 0;
			}
		});
		List<int[]> result = new ArrayList<>();
		int start = intervals[0][0];
		int end = intervals[0][1];
		int arrPtr = 0;
		while(arrPtr < intervals.length) {
			if(intervals[arrPtr][0] > end) {
				result.add(new int[] {start, end});
				start = intervals[arrPtr][0];
				end = intervals[arrPtr][1];
				arrPtr++;
				continue;
			}
			if(intervals[arrPtr][1] > end) {
				end = intervals[arrPtr][1];
			}
			arrPtr++;
		}
		result.add(new int[] {start, end});
		int[][] resultArr = new int[result.size()][2];
		for(int i=0; i<resultArr.length; i++) {
			resultArr[i][0] = result.get(i)[0];
			resultArr[i][1] = result.get(i)[1];
		}
		return resultArr;
	}
}
