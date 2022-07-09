class Solution {
    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private List<int[]> spaces = new ArrayList<int[]>();
    boolean valid = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.')
                    spaces.add(new int[] { i, j });
                else {
                    int d = board[i][j] - '0' - 1;
                    line[i][d] = column[j][d] = block[i / 3][j / 3][d] = true;
                }
            }
        }
        backtrack(board, 0);
    }

    public void backtrack(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0];
        int j = space[1];
        for (int k = 0; k < 9 && !valid; ++k) {
            if (!line[i][k] && !column[j][k] && !block[i / 3][j / 3][k]) {
                line[i][k] = column[j][k] = block[i / 3][j / 3][k] = true;
                board[i][j] = (char) (k + '0' + 1);
                backtrack(board, pos + 1);
                line[i][k] = column[j][k] = block[i / 3][j / 3][k] = false;
            }
        }
    }
}