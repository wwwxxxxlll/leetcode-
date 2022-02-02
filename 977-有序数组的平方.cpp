class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int left = 0, right = nums.size() - 1;
        int k = 0;
        vector<int> result(nums.size(), 0);
        while(left<=right){
            if(pow(nums[left],2)<pow(nums[right],2)){
                result[nums.size()-1-k++] = pow(nums[right--],2);
            }
            else{
                result[nums.size()-1-k++] = pow(nums[left++],2);
            }
        }
        return result;
    }
};
