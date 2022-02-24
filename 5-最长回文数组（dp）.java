class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int begin = 0;
        int len = 1;
        if(n < 2)
            return s;
        int l1 = 0, r1 = 0;
        boolean [][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < n; j++){
                int r = i + j - 1;
                if(r>=n)
                    break;
                if(s.charAt(j) == s.charAt(r)){
                    if(r - j < 3){
                        dp[j][r] = true;
                    }
                    else{
                        dp[j][r] = dp[j+1][r-1];
                    }
                }
                else
                    dp[j][r] = false;
                if(dp[j][r] == true && r-j+1 > len){
                    len = r-j+1;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + len);

    }
}