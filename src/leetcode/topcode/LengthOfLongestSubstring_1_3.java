package leetcode.topcode;

import java.util.HashMap;

/**
 * @Description: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @url: https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @Date: 2022/10/1
 * @Author: Zirui Wang
 */
public class LengthOfLongestSubstring_1_3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(s));
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了87.33%的用户
     * 内存消耗：42 MB, 在所有 Java 提交中击败了13.89%的用户
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s){
        if(s.length() == 0 || s == null){
            return 0;
        }
        int result = 0;
        int i = 0;
        char[] sArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        while(i != sArr.length){
            int sbIdx = sb.indexOf(String.valueOf(sArr[i]));
            if(sbIdx >= 0){
                sb.delete(0, sbIdx+1);
            }
            sb.append(sArr[i]);
            if(sb.length() > result){
                result = sb.length();
            }
            i++;
        }
        return result;
    }

    /**
     * 执行用时：67 ms, 在所有 Java 提交中击败了12.18%的用户
     * 内存消耗：42.4 MB, 在所有 Java 提交中击败了5.01%的用户
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s){
        if(s.length() == 0 || s == null){
            return 0;
        }
        int result = 1;
        char[] sArr = s.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i < sArr.length; i++){
            if(!hm.containsKey(sArr[i])){
                hm.put(sArr[i], i);
                int currLength = hm.size();
                if(currLength > result){
                    result = currLength;
                }
                continue;
            }
            int nextIdx = hm.get(sArr[i]);
            i = nextIdx;
            hm.clear();
        }
        return result;
    }
}
