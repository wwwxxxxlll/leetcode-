class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(),candidates.end());
        vector<vector<int>> res;
        vector<int> temp;
        backtrack(candidates,target,0,res,temp);
        return res;

    }
    void backtrack(vector<int>& candidates, int target, int start,vector<vector<int>>& res, vector<int> & temp){
        if(target == 0){
            res.push_back(temp);
            return;
        }
        if(start > candidates.size() - 1)
            return;
        if(candidates[start] > target)
            return;
        backtrack(candidates, target, start+1, res, temp);
        temp.push_back(candidates[start]);
        backtrack(candidates, target-candidates[start], start, res, temp);
        temp.pop_back();
        return;
    }
};