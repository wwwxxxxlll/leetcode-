class Solution {
    static boolean[][] used;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int num = 0;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        used = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!used[i][j] && grid[i][j] == '1') {
                    num++;
                    backtrack(grid, i, j, used);
                }
            }
        }
        return num;
    }

    public void backtrack(char[][] grid, int stx, int sty, boolean[][] used) {
        if (stx >= 0 && sty >= 0 && stx < grid.length && sty < grid[0].length) {
            if (!used[stx][sty] && grid[stx][sty] == '1') {
                used[stx][sty] = true;
            } else {
                return;
            }
            backtrack(grid, stx + 1, sty, used);
            backtrack(grid, stx, sty + 1, used);
            backtrack(grid, stx - 1, sty, used);
            backtrack(grid, stx, sty - 1, used);
        }
    }
}