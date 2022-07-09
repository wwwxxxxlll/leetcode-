class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        if (m * n == 0)
            return m + n;
        for (int i = 0; i < m + 1; ++i) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; ++i) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                int l1 = dp[i][j - 1] + 1;
                int l2 = dp[i - 1][j] + 1;
                int l3 = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    ++l3;
                dp[i][j] = Math.min(l1, Math.min(l2, l3));
            }
        }
        return dp[m][n];
    }
}