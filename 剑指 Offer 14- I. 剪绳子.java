class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        int cur_max = 0;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                cur_max = Math.max(cur_max, Math.max(j*dp[i-j],j*(i-j)));
            }
            dp[i] = cur_max;
        }
        return dp[n];
    }
}