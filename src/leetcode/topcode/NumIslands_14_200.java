package leetcode.topcode;

/**
 * @Description: 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *  岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *  此外，你可以假设该网格的四条边均被水包围。
 * @url: https://leetcode.cn/problems/number-of-islands/
 * @Date: 2022/10/6
 * @Author: Zirui Wang
 */
public class NumIslands_14_200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }

    /**
     * 思路：找到'1'后使用深度优先搜索将所有'1'变为'0'，进行深度优先搜索的次数就是岛屿的数量
     * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：49.5 MB, 在所有 Java 提交中击败了79.14%的用户
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid){
        int result = 0;
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[row].length; col++){
                if(grid[row][col] == '1'){
                    depthFirstSearch(grid, row, col);
                    result++;
                }
            }
        }
        return result;
    }
    public static void depthFirstSearch(char[][] grid, int row, int col){
        if(grid[row][col] == '0'){
            return;
        }
        grid[row][col] = '0';
        if(row != 0){
            depthFirstSearch(grid, row-1, col);
        }
        if(col != 0){
            depthFirstSearch(grid, row, col-1);
        }
        if(row != grid.length-1){
            depthFirstSearch(grid, row+1, col);
        }
        if(col != grid[row].length-1){
            depthFirstSearch(grid, row, col+1);
        }
    }
}
