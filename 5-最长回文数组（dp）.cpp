class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        if(n < 2)
            return s;
        else{
            vector<vector<bool>> dp(n,vector<bool>(n,false));//最小长度为1，防止最后返回时不返回子串
            int maxlen = 1, begin = 0;
            int i = 0, j = 0, l = 0;
            for(i = 0; i< n; i++)
                dp[i][i] = true;
            for(l = 2; l<=n; l++){
                for(i = 0;i<n;i++){
                    int r = i + l - 1;
                    if(r>=n)
                        break;
                    if(s[i] == s[r]){
                        if(r - i < 3)//长度不足3时才置为真，否则与去头尾的子串一致
                            dp[i][r] = true;
                        else
                            dp[i][r] = dp[i + 1][r - 1];
                    }
                    else
                        dp[i][r] = false;
                    if(dp[i][r]&&r-i + 1>maxlen){
                        begin = i;
                        maxlen = r - i + 1;
                    }
                }
            }
            return s.substr(begin,maxlen);
        }
    }
};