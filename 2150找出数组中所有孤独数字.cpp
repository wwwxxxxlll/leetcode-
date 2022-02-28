class Solution {
public:
    vector<int> findLonely(vector<int>& nums) {
        // 避免额外判断边界条件
        nums.push_back(-2);
        nums.push_back(INT_MAX);
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<int> res;
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] - nums[i-1] > 1 && nums[i+1] - nums[i] > 1) {
                res.push_back(nums[i]);
            }
        }
        return res;
    }
};
