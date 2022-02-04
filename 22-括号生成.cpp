class Solution {
public:
    vector<string> generateParenthesis(int n) {
        string s;
        vector<string> ans;
        backtrack(ans,0,0,s,n);
        return ans;
    }
    void backtrack(vector<string>& ans, int left, int right, string& s, int n){
        if(s.size() == 2*n)
            ans.push_back(s);
        else{
            if(left<n){
                s.push_back('(');
                backtrack(ans,left+1,right,s,n);
                s.pop_back();
            }
            if(right<left){
                s.push_back(')');
                backtrack(ans,left,right+1,s,n);
                s.pop_back();
            }
        }
        return;
    }
};