package leetcode.topcode;

import leetcode.common.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *  百度百科中最近公共祖先的定义为：
 *  “对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * @url: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 * @Date: 2022/10/9
 * @Author: Zirui Wang
 */
public class LowestCommonAncestor_19_236 {

    /**
     * 深度优先搜索，记录父节点
     * 执行用时：337 ms, 在所有 Java 提交中击败了5.53%的用户
     * 内存消耗：42.7 MB, 在所有 Java 提交中击败了63.20%的用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    List<TreeNode> pAncestor;
    List<TreeNode> qAncestor;
    TreeNode p;
    TreeNode q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        this.p = p;
        this.q = q;
        helper(root, new ArrayList<>());
        TreeNode result = null;
        for(int i=0; i<pAncestor.size() && i < qAncestor.size(); i++){
            if(pAncestor.get(i) == qAncestor.get(i)){
                result = pAncestor.get(i);
                continue;
            }
            break;
        }
        return result;
    }
    public void helper(TreeNode currNode, List<TreeNode> currAncestor){
        if(currNode == null){
            return;
        }
        currAncestor.add(currNode);
        if(currNode == p){
            pAncestor = new ArrayList<>(currAncestor);
        }
        if(currNode == q){
            qAncestor = new ArrayList<>(currAncestor);
        }
        helper(currNode.left, currAncestor);
        currAncestor.remove(currNode.left);
        helper(currNode.right, currAncestor);
        currAncestor.remove(currNode.right);
    }
}
