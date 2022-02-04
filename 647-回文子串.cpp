class Solution {
public:
    int countSubstrings(string s) {
        int n = s.size();
        if(n < 2)
            return 1;
        vector<vector<bool>> dp(n,vector<bool>(n,false));
        int l = 1, i = 0, r = 0;
        int cnt = 0;
        for(i = 0; i< n; i++)
            dp[i][i] = true;
        for(;l<=n;l++){
            for(i = 0;i<n;i++){
                r = i + l - 1;
                if(r>=n)
                    break;
                if(s[i] == s[r]){
                    if(r - i < 3)
                        dp[i][r] = true;
                    else
                        dp[i][r] =  dp[i+1][r-1];
                }
                else{
                    dp[i][r] = false;
                }
                if(dp[i][r]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
};
