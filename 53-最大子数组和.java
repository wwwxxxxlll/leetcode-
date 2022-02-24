动态规划，直到出现一个比和更大的值才替换
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int max = -100000;
        for(int i = 0; i < n; i++){
            
            if(nums[i] < ans + nums[i]){
                ans = ans+nums[i];
            }
            else{
                ans = nums[i];
            }
            if(max < ans)
                max = ans;
        }
        return max;
    }
}