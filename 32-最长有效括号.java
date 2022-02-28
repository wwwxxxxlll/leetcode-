class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int maxlen = 0;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '('){
                dp[i] = 0;
            }
            else{
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                else{
                    int l = i - dp[i - 1] - 1;
                    if(l>=0){
                        if(s.charAt(l) == '('){
                            dp[i] = dp[i - 1] + 2;
                            if(l>=1){
                                dp[i] += dp[l-1];
                            }
                        }
                    }
                }
            }
            if(dp[i]>maxlen)
                maxlen = dp[i];
        }
        return maxlen;
    }
}