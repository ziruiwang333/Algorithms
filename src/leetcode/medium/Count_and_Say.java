package leetcode.medium;

/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * 
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), 
 * which is then converted into a different digit string.
 * 
 * To determine how you "say" a digit string, split it into the minimal number of groups so that 
 * each group is a contiguous section all of the same character. Then for each group, say the 
 * number of characters, then say the character. To convert the saying into a digit string, replace 
 * the counts with a number and concatenate every saying.
 * 
 * For example, the saying and conversion for digit string "3322251": "23 32 15 11"
 * 
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/count-and-say/
 */

public class Count_and_Say {

	public static void main(String[] args) {
		int n = 4;
		System.out.println(mySol(n));
	}
	
	public static String mySol(int n) {
		return helper(n);
	}
	
	public static String helper(int n) {
		if(n == 1) {
			return "1";
		}
		String str = helper(n-1);
		StringBuilder result = new StringBuilder();
		int count = 1;
		for(int i=0; i<str.length(); i++) {
			if(i!=str.length()-1 && str.charAt(i)==str.charAt(i+1)) {
				count++;
				continue;
			}
			result.append(count + "" + str.charAt(i));
			count = 1;
		}
		return result.toString();
	}

}
