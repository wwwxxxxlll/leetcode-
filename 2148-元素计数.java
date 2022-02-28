class Solution {
    public int countElements(int[] nums) {
        int n = nums.length;
        int ans = 0;
        if(n<3)
            return ans;
        Arrays.sort(nums);
        for(int i = 1; i < n - 1; ++i){
            if(nums[i]>nums[0]&&nums[i]<nums[n-1])
                ++ans;
        }
        return ans;
    }
}