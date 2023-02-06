class Solution {
    public static int w;
    public static int d;

    public static boolean checkValid(int x, int y) {
        if (x >= 0 && y >= 0 && x < d && y < w) {
            return true;
        }
        return false;
    }

    public int largestIsland(int[][] grid) {

        Map<Integer, Integer> area = new HashMap<Integer, Integer>();
        d = grid.length;
        if (d == 0) {
            return 0;
        }
        w = grid[0].length;
        if (w == 0) {
            return 0;
        }
        int t = 1;
        int[][] tags = new int[d][w];
        int max = 0;
        for (int i = 0; i < d; ++i) {
            for (int j = 0; j < w; ++j) {
                if (grid[i][j] == 1 && tags[i][j] == 0) {
                    area.put(t, dfs(grid, tags, i, j, t));
                    max = Math.max(max, area.get(t));
                    ++t;
                }
            }
        }
        int t1, t2, t3;
        for (int x = 0; x < d; ++x) {
            for (int y = 0; y < w; ++y) {
                if (grid[x][y] == 0) {
                    t1 = 0;
                    t2 = 0;
                    t3 = 0;
                    int z = 1;
                    if (checkValid(x - 1, y) && grid[x - 1][y] == 1) {
                        z += area.get(tags[x - 1][y]);
                        t1 = tags[x - 1][y];
                    }
                    if (checkValid(x + 1, y) && grid[x + 1][y] == 1 && tags[x + 1][y] != t1) {
                        z += area.get(tags[x + 1][y]);
                        t2 = tags[x + 1][y];
                    }
                    if (checkValid(x, y - 1) && grid[x][y - 1] == 1 && tags[x][y - 1] != t1 && tags[x][y - 1] != t2) {
                        z += area.get(tags[x][y - 1]);
                        t3 = tags[x][y - 1];
                    }
                    if (checkValid(x, y + 1) && grid[x][y + 1] == 1 && tags[x][y + 1] != t1 && tags[x][y + 1] != t2
                            && tags[x][y + 1] != t3) {
                        z += area.get(tags[x][y + 1]);
                    }
                    max = Math.max(z, max);
                }
            }
        }
        return max;
    }

    public static int dfs(int[][] grid, int[][] tags, int x, int y, int t) {
        int res = 1;
        tags[x][y] = t;
        if (checkValid(x - 1, y) && grid[x - 1][y] == 1 && tags[x - 1][y] == 0) {
            res += dfs(grid, tags, x - 1, y, t);
        }
        if (checkValid(x + 1, y) && grid[x + 1][y] == 1 && tags[x + 1][y] == 0) {
            res += dfs(grid, tags, x + 1, y, t);
        }
        if (checkValid(x, y - 1) && grid[x][y - 1] == 1 && tags[x][y - 1] == 0) {
            res += dfs(grid, tags, x, y - 1, t);
        }
        if (checkValid(x, y + 1) && grid[x][y + 1] == 1 && tags[x][y + 1] == 0) {
            res += dfs(grid, tags, x, y + 1, t);
        }
        return res;
    }
}