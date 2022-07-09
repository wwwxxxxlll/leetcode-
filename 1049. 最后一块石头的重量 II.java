class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        if (n == 1)
            return stones[0];
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= stones[i]) {
                    dp[i + 1][j] = dp[i][j] || dp[i][j - stones[i]];
                } else {
                    dp[i + 1][j] = dp[i][j];
                }
            }
        }
        for (int k = target; k >= 0; k--) {
            if (dp[n][k]) {
                return sum - 2 * k;
            }
        }
        return 0;
    }
}