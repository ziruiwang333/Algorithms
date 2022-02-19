package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Given an array of strings strs, group the anagrams together. 
 * You can return the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a different 
 * word or phrase, typically using all the original letters exactly once.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/group-anagrams/
 */

public class Group_Anagrams {

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> result = mySol(strs);
		Iterator<List<String>> iterator = result.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public static List<List<String>> mySol(String[] strs){
		List<List<String>> result = new ArrayList<>();
		if(strs.length == 0) {
			return result;
		}
		HashMap<String, List<String>> hm = new HashMap<>();
		for(int i=0; i<strs.length; i++) {
			char[] charArray = strs[i].toCharArray();
			Arrays.sort(charArray);
			String charStr = String.valueOf(charArray);
			if(hm.containsKey(charStr)) {
				List<String> tempList = hm.get(charStr);
				tempList.add(strs[i]);
			} else {
				List<String> temp = new ArrayList<>();
				temp.add(strs[i]);
				hm.put(charStr, temp);
			}
		}
		 Iterator<List<String>> iterator = hm.values().iterator();
		 while(iterator.hasNext()) {
			 result.add(iterator.next());
		 }
		return result;
	}

}
