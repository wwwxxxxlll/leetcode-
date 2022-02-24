class Solution {//无论如何移动一定会产生一侧有序，一侧无序的结果，因此可以使用一套方法匹配
public:
    int search(vector<int>& nums, int target) {
        int right = nums.size();
         if (!right) {
            return -1;
        }
        if (right == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        right -= 1;
        int mid;
        while(left<=right){
            mid = (left+right)>>1;
            if(nums[mid] == target)
                return mid;
            if(nums[mid]>=nums[left])//左侧有序
            {
                if(nums[left]<=target && nums[mid]>target){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{//右侧有序
                if(nums[mid]<target && nums[right]>=target){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
};