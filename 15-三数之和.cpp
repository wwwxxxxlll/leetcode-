class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<vector<int>> res(0,vector<int>(0)); 
        if(nums.size()<3){
            return res;
        } 
        if(*nums.begin()>0){
            return res;
        }
        vector<vector<int>> ans; 
        int n = nums.size();
        for(int i = 0;i<n;i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                int k = n - 1;
                for(int j = i + 1;j<n;j++){
                    if(j == i + 1 || nums[j] != nums[j - 1]){
                        while(j<k&&nums[i]+nums[j]+nums[k]>0){
                            k--;
                        }
                        if(j==k)
                            break;
                        if(nums[i]+nums[j]+nums[k] == 0)
                            ans.push_back({nums[i], nums[j], nums[k]});
                    }
                    else{
                        continue;
                    }
                }
            }
            else{
                continue;
            }
        }
        return ans;
    }
};