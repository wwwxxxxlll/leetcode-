class Solution {
    public boolean canJump(int[] nums) {
        int rightmost = 0;
        int n = nums.length;
        for(int i = 0 ;i < n; i++){
            if(i<=rightmost)
                rightmost = Math.max(rightmost,i+nums[i]);
        }
        if(rightmost >= n-1)
            return true;
        return false;
    }
}