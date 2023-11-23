//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。 
//
// 请返回 封闭岛屿 的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,1,1,1,1,0],
//             [1,0,0,0,0,1,1,0],
//             [1,0,1,0,1,1,1,0],
//             [1,0,0,0,0,1,0,1],
//             [1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 275 👎 0


package com.fengyq.leetcode.editor.cn;

public class LC1254NumberOfClosedIslands {
    public static void main(String[] args) {
        Solution solution = new LC1254NumberOfClosedIslands().new Solution();
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}
        };
        System.out.println(solution.closedIsland(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int closedIsland(int[][] grid) {
            //先淹上下左右的岛屿
            int res = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[0][j] == 1) {
                    continue;
                }
                dfs(grid, 0, j);
            }
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[grid.length - 1][j] == 1) {
                    continue;
                }
                dfs(grid, grid.length - 1, j);
            }
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][0] == 1) {
                    continue;
                }
                dfs(grid, j, 0);
            }
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][grid[j].length - 1] == 1) {
                    continue;
                }
                dfs(grid, j, grid[j].length - 1);
            }

            //再淹中间的岛屿
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        continue;
                    }

                    res++;
                    dfs(grid, i, j);
                }
            }
            return res;
        }

        void dfs(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] == 1) {
                return;
            }

            grid[i][j] = 1;
            dfs(grid, i, j + 1);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i - 1, j);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}