package leetcode.medium;

/**
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]). Find two lines that together with the x-axis form a container,
 * such that the container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/container-with-most-water/
 */

public class Container_With_Most_Water {

	public static void main(String[] args) {
		int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(mySol(height));
		System.out.println(optimizedSol(height));
	}

	//Time Limit Exceeded
	public static int mySol(int[] height) {
		int[] dpArray = new int[height.length];
		int result = 0;
		for (int edgeNum = 1; edgeNum < dpArray.length; edgeNum++) {
			for (int heightIdx = edgeNum; heightIdx < dpArray.length; heightIdx++) {
				int minHeight = height[heightIdx] > height[heightIdx - edgeNum] ? height[heightIdx - edgeNum]
						: height[heightIdx];
				int tempArea = edgeNum * minHeight;
				if (tempArea < dpArray[heightIdx - 1]) {
					tempArea = dpArray[heightIdx - 1];
				}
				if (tempArea < dpArray[heightIdx]) {
					tempArea = dpArray[heightIdx];
				}
				dpArray[heightIdx] = tempArea;
				if(tempArea > result) {
					result = tempArea;
				}
			}
		}

		return result;
	}
	
	public static int optimizedSol(int[] height) {
		int result = 0;
		int i = 0;
		int j = height.length-1;
		while(i<j) {
			int minHeight = height[i] > height[j] ? height[j] : height[i];
			int temp = (j - i) * minHeight;
			if(temp > result) {
				result = temp;
			}
			if(height[i] > height[j]) {
				j--;
				continue;
			}
			i++;
		}
		return result;
	}

}
