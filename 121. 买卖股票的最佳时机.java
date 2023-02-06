class Solution {
    public int maxProfit(int[] prices) {
        int hist = Integer.MAX_VALUE;
        int max_int = 0;
        int diff = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (hist > prices[i]) {
                hist = prices[i];
            }
            diff = prices[i] - hist;
            if (diff > max_int) {
                max_int = diff;
            }
        }
        return max_int;
    }
}