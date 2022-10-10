package leetcode.topcode;

import com.sun.jmx.remote.internal.ArrayQueue;
import leetcode.common.treeNode.TreeNode;

import java.util.*;

/**
 * @Description: 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 *  （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @url: https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 * @Date: 2022/10/9
 * @Author: Zirui Wang
 */
public class ZigzagLevelOrder_20_103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(zigzagLevelOrder(root));
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了69.39%的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了88.75%的用户
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        Stack<TreeNode> toRight = new Stack<>();
        Stack<TreeNode> toLeft = new Stack<>();
        toRight.add(root);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while (!toRight.isEmpty() || !toLeft.isEmpty()){
            while (!toRight.isEmpty()){
                TreeNode currNode = toRight.pop();
                list.add(currNode.val);
                if(currNode.left != null){
                    toLeft.add(currNode.left);
                }
                if(currNode.right != null){
                    toLeft.add(currNode.right);
                }
            }
            result.add(list);
            list = new ArrayList<>();
            while (!toLeft.isEmpty()){
                TreeNode currNode = toLeft.pop();
                list.add(currNode.val);
                if(currNode.right != null){
                    toRight.add(currNode.right);
                }
                if(currNode.left != null){
                    toRight.add(currNode.left);
                }
            }
            if(!list.isEmpty()){
                result.add(list);
                list = new ArrayList<>();
            }
        }
        return result;
    }
}
