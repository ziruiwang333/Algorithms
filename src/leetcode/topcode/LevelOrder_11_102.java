package leetcode.topcode;

import leetcode.common.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。（即逐层地，从左到右访问所有节点）。
 * @url: https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * @Date: 2022/10/5
 * @Author: Zirui Wang
 */
public class LevelOrder_11_102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(levelOrder(root));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.4 MB, 在所有 Java 提交中击败了65.97%的用户
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int thisLevel = 1;
        int nextLevel = 0;
        List<Integer> currLevelList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()){
            if(thisLevel != 0){
                TreeNode currNode = queue.poll();
                currLevelList.add(currNode.val);
                thisLevel--;
                if(currNode.left != null){
                    queue.add(currNode.left);
                    nextLevel++;
                }
                if(currNode.right != null){
                    queue.add(currNode.right);
                    nextLevel++;
                }
            }
            if(thisLevel == 0){
                result.add(currLevelList);
                currLevelList = new ArrayList<>();
                thisLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return result;
    }
}
