package leetcode.medium;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
 * of rows like this: (you may want to display this pattern in a fixed font for 
 * better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * @author zirui
 * @url https://leetcode.com/problems/zigzag-conversion/
 */

public class Zigzag_Conversion {

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 4;
		System.out.println(mySol(s, numRows).equals("PINALSIGYAHRPI"));
	}
	
	public static String mySol(String s, int numRows) {
		if(numRows == 1) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		int cycle = (numRows-1) + (numRows-2) + 1;
		for(int i=0; i<numRows; i++) {
			for(int j=i; j<s.length(); j=j+cycle) {
				sb.append(s.charAt(j));
				if((i!=0 && i!=numRows-1) && j+(numRows-2)*2-2*(i-1)<s.length()) {
					sb.append(s.charAt(j+ ((numRows-2)*2-2*(i-1)) ));
				}
			}
		}
		return sb.toString();
	}

}
