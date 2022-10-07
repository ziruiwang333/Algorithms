package leetcode.topcode;

import java.util.Stack;

/**
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *  有效字符串需满足：
 *      1. 左括号必须用相同类型的右括号闭合。
 *      2. 左括号必须以正确的顺序闭合。
 *      3. 每个右括号都有一个对应的相同类型的左括号。
 * @url: https://leetcode.cn/problems/valid-parentheses/
 * @Date: 2022/10/7
 * @Author: Zirui Wang
 */
public class IsValid_15_20 {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}{({})}"));
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.91%的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了29.08%的用户
     * @param s
     * @return
     */
    public static boolean isValid(String s){
        if(s == null || s.length() <= 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char currChar = s.charAt(i);
            if(currChar == '(' || currChar == '{' || currChar == '['){
                stack.add(currChar);
                continue;
            }
            if(stack.empty()){
                return false;
            }
            char temp = stack.pop();
            if(currChar == ')' && temp == '('){
                continue;
            }
            if(currChar == '}' && temp == '{'){
                continue;
            }
            if(currChar == ']' && temp == '['){
                continue;
            }
            return false;
        }
        return stack.empty();
    }
}
