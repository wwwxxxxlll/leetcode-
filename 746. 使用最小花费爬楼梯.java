class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int step = 2;
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        while (step < n) {
            dp[step] = Math.min(dp[step - 2] + cost[step], dp[step - 1] + cost[step]);
            ++step;
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}