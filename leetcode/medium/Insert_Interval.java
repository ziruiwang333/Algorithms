package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where 
 * intervals[i] = [starti, endi] represent the start and the end of the 
 * ith interval and intervals is sorted in ascending order by starti. 
 * You are also given an interval newInterval = [start, end] that represents the 
 * start and end of another interval.
 * 
 * Insert newInterval into intervals such that intervals is still sorted in 
 * ascending order by starti and intervals still does not have any overlapping 
 * intervals (merge overlapping intervals if necessary).
 * 
 * Return intervals after the insertion.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/insert-interval/
 */

public class Insert_Interval {

	public static void main(String[] args) {
		int[][] intervals = {
				{2,5},
				{6,7},
				{8,9}
		};
		int[] newInterval = {0,1};
		int[][] result = mySol(intervals, newInterval);
		for(int[] i: result) {
			System.out.println(Arrays.toString(i));
		}
	}
	
	public static int[][] mySol(int[][] intervals, int[] newInterval){
		List<int[]> result = new ArrayList<>();
		int start = newInterval[0];
		int end = newInterval[1];
		int intPtr = 0;
		while(true) {
			if(intPtr == intervals.length) {
				result.add(new int[] {start, end});
				break;
			}
			if(start <= intervals[intPtr][1]) {
				start = start > intervals[intPtr][0] ? intervals[intPtr][0] : start;
			}
			if(end <= intervals[intPtr][1]) {
				end = end >= intervals[intPtr][0] ? intervals[intPtr][1] : end;
				result.add(new int[] {start, end});
				if(end >= intervals[intPtr][0]) {
					intPtr++;
				}
				break;
			}
			if(intervals[intPtr][1] < start) {
				result.add(new int[] {intervals[intPtr][0], intervals[intPtr][1]});
			}
			intPtr++;
		}
		for(int i=intPtr; i<intervals.length; i++) {
			result.add(new int[] {intervals[i][0], intervals[i][1]});
		}
		int[][] resultArr = new int[result.size()][2];
		for(int i=0; i<resultArr.length; i++) {
			resultArr[i][0] = result.get(i)[0];
			resultArr[i][1] = result.get(i)[1];
		}
		return resultArr;
	}

}
