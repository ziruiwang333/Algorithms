package leetcode.easy;

import java.util.HashMap;

/**
 * Roman numerals are represented by seven different symbols: 
 * I, V, X, L, C, D and M.
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * @author zirui
 * @url https://leetcode.com/problems/roman-to-integer/
 */

public class Roman_To_Integer {

	public static void main(String[] args) {
		String s = "MCMXCIV";
		System.out.println(mySol(s));
	}
	
	public static int mySol(String s) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		map.put("IV", 4);
		map.put("IX", 9);
		map.put("XL", 40);
		map.put("XC", 90);
		map.put("CD", 400);
		map.put("CM", 900);
		
		int result = 0;
		while( !(2 > s.length())) {
			String temp = s.substring(0, 2);
			if(map.get(temp)==null) {
				temp = s.substring(0,1);
				s = s.substring(1);
			} else {
				s = s.substring(2);
			}
			result += map.get(temp);
		}
		return s.length()==0?result:result+map.get(s);
	}

}
