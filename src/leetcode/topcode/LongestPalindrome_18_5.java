package leetcode.topcode;

/**
 * @Description: 给你一个字符串 s，找到 s 中最长的回文子串。
 * @url: https://leetcode.cn/problems/longest-palindromic-substring/
 * @Date: 2022/10/8
 * @Author: Zirui Wang
 */
public class LongestPalindrome_18_5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }

    /**
     * 思路：中心扩散法，记录中间索引，最大长度，开始位置=中间索引-（最大长度-1）/ 2
     * 执行用时：7 ms, 在所有 Java 提交中击败了94.76%的用户
     * 内存消耗：41.1 MB, 在所有 Java 提交中击败了90.64%的用户
     * @param s
     * @return
     */
    public static String longestPalindrome(String s){
        if(s == null || s.length() <= 1){
            return s;
        }
        char[] sCharArr = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        for(int i=0; i<sCharArr.length-1; i++){
            int oddLen = helper(sCharArr, i, i);
            int evenLen = helper(sCharArr, i, i+1);
            int currLen = Math.max(oddLen, evenLen);
            if(currLen > maxLen){
                maxLen = currLen;
                begin = i - (maxLen - 1) / 2;
            }
        }
        System.out.println(begin + " " + maxLen);
        return s.substring(begin, begin+maxLen);
    }
    public static int helper(char[] sCharArr, int i, int j){
        int result = 1;
        if(i != j){
            if(sCharArr[i] == sCharArr[j]){
                result++;
            }
            else {
                return result;
            }
        }
        i--;
        j++;
        while (i != -1 && j != sCharArr.length) {
            if(sCharArr[i] == sCharArr[j]){
                result += 2;
                i--;
                j++;
                continue;
            }
            break;
        }
        return result;
    }
}
