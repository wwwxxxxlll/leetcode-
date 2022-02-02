class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int start = 0, end = 0;
        int len = INT_MAX, n = nums.size();//依旧是双指针，维护左右位置，每当子数组大小达到边界就更新最小长度，并移动两个指针
        int temp_sum = 0;
        if(n == 0)
            return 0;
        while(end<n){
            temp_sum += nums[end++];
            while(temp_sum>=target){
                len = min(end-start,len);
                temp_sum -= nums[start++];
            }
        }
        return len==INT_MAX?0:len;
    }
};
