class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int fast = 0,slow = 0;
        for(;fast<nums.size();fast++){
            if(val != nums[fast]){
                nums[slow++] = nums[fast];//快慢指针值得注意 
            }
        }
        return fast;
    }
};
