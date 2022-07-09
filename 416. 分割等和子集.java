class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int k : nums) {
            sum += k;
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= target; ++j) {
                if (j >= nums[i])
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n - 1][target];
    }
}