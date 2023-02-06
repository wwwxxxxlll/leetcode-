class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            if (max != 0) {
                dp[i] = max + 1;
            }
        }
        Arrays.sort(dp);
        return dp[n - 1];
    }
}