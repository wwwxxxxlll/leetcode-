class Solution {
public:
    int longestValidParentheses(string s) {
        int n = s.size();
        int maxlen = 0;
        vector<int> dp(n,0);
        for(int i = 1; i < n; i++){
            if(s[i] == ')'){
                if(s[i-1] == '(')
                    dp[i] = (i-2>=0?dp[i-2]:0)+2;
                else{
                    if(i-dp[i-1]-1 >= 0){
                        if(s[i-dp[i-1]-1] == '('){
                            dp[i] = dp[i-1] + 2;
                            if((i-dp[i-1]-2) >= 0)
                                dp[i] += dp[i-dp[i-1]-2];
                        }
                    }
                }
                if(dp[i]>maxlen)
                    maxlen = dp[i];
            }
        }
        return maxlen;
    }
};
//错误解答，需要解决，已解决，需要注意if后面内容的作用域
// class Solution {
// public:
//     int longestValidParentheses(string s) {
//         int n = s.size();
//         int maxlen = 0;
//         vector<int> dp(n,0);
//         for(int i = 1; i<n; i++){
//             if(s[i] == '(')
//                 dp[i] = 0;
//             else{
//                 if(s[i-1] == '('){
//                     dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//                 }
//                 else{
//                     if(i - dp[i-1] - 1 >=0){
//                         int l = i - dp[i-1] - 1;
//                         if(s[l] == '(')
//                             dp[i] = dp[i-1]+2;
//                         if(l-1>=0)
//                             dp[i] += dp[l-1];
//                     }
                    
//                 }
                
//             }
//             if(dp[i]>maxlen)
//                 maxlen = dp[i];
//         }
//         return maxlen;
//     }
// };
//
// class Solution {
// public:
//     int longestValidParentheses(string s) {
//         int n = s.size();
//         int maxlen = 0;
//         vector<int> dp(n,0);
//         for(int i = 1; i<n; i++){
//             if(s[i] == '(')
//                 dp[i] = 0;
//             else{
//                 if(s[i-1] == '('){
//                     dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//                 }
//                 else{
//                     if(i - dp[i-1] - 1 >=0){
//                         int l = i - dp[i-1] - 1;
//                         if(s[l] == '('){
//                             dp[i] = dp[i-1]+2;
//                         if(l-1>=0)
//                             dp[i] += dp[l-1];

//                         }
//                     }
//                     ;
                    
                    
//                 }
                
//             }
//             if(dp[i]>maxlen)
//                 maxlen = dp[i];
//         }
//         return maxlen;
//     }
// };
// 栈做法
// class Solution {
// public:
//     int longestValidParentheses(string s) {
//         stack<int> stk;
//         stk.push(-1);
//         int l = 0;
//         int n = s.size();
//         for(int i = 0;i < n; i++){
//             if(s[i] == '(')
//                 stk.push(i);
//             else{
//                 stk.pop();
//                 if(stk.empty()){
//                     stk.push(i);
//                 }
//                 else{
//                     l = l>(i - stk.top())?l:(i - stk.top());
//                 }
                
//             }
//         }
//         return l;
//     }
// };