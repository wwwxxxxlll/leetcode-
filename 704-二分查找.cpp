class Solution {
public:
    int search(vector<int>& nums, int target) {
        int res = -1;
        int left = 0, right = nums.size() - 1, middle = (right+left)/2;
        while(left <= right){
            if(nums[middle]==target)
                return middle;
            if(nums[middle]>target){
                right = middle - 1;
                middle = (right+left)/2;
            }
            else{
                left = middle + 1;
                middle = (right+left)/2;
            }
        }
        return res;
    }
};
