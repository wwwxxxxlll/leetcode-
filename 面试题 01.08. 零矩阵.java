class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Integer> column = new HashSet<Integer>();
        HashSet<Integer> row = new HashSet<Integer>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }
        for (Integer x : row) {
            for (int j = 0; j < n; ++j) {
                matrix[x][j] = 0;
            }
        }
        for (Integer x : column) {
            for (int i = 0; i < m; ++i) {
                matrix[i][x] = 0;
            }
        }
    }
}