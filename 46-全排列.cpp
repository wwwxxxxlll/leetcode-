class Solution {
public:
    void backtrack(int start,int end, vector<int>&source, vector<vector<int>>&res){
        if(start == end){
            res.push_back(source);
            return;
        }
        for(int i = start; i<end; i++){
            swap(source[start],source[i]);
            backtrack(start+1,end,source,res);
            swap(source[start],source[i]);
        }
        return;
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        backtrack(0,nums.size(),nums,res);
        return res;
    }
};
// used数组做法
// class Solution {
// public:
//     void backtrack(int len,int end, vector<int>&source, vector<vector<int>>&res,vector<int>nums,vector<int>used){
//         if(len == end){
//             res.push_back(source);
//             return;
//         }
//         for(int i = 0; i<end; i++){
//             if(!used[i]){
//                 source.push_back(nums[i]);
//                 used[i] = !used[i];
//                 backtrack(len+1,end,source,res,nums,used);
//                 source.pop_back();
//                 used[i] = !used[i];
//             }
//         }
//         return;
//     }
//     vector<vector<int>> permute(vector<int>& nums) {
//         vector<vector<int>> res;
//         vector<int> source;
//         vector<int> used(nums.size(),0);
//         backtrack(0,nums.size(),source,res,nums,used);
//         return res;
//     }
// };