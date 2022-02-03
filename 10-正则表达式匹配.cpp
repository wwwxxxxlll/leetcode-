class Solution {
public:
    bool matches(string s, string p, int i, int j){
        if(i == 0)
            return false;
        if(p[j - 1] == '.')
            return true;
        return p[j - 1] == s[i - 1];
    }//注意循环条件
    bool isMatch(string s, string p) {
        int ls = s.size(), lp = p.size();
        vector<vector<bool>> dp(ls+1,vector<bool>(lp+1,false));
        dp[0][0] = true;
        for(int i = 0;i<=ls;i++){
            for(int j = 1;j<=lp;j++){
                if(p[j-1] == '*'){
                    dp[i][j] = dp[i][j - 2];
                    if(matches(s, p, i, j - 1)){
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
                else{
                    if(matches(s,p,i,j)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[ls][lp];
    }
};