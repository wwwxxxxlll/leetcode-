class Solution {
    public int maxSubArray(int[] nums) {
        int temp = nums[0];
        int max = temp;
        for (int i = 1; i < nums.length; ++i) {
            if (temp < 0) {
                temp = nums[i];
                max = Math.max(temp, max);
                continue;
            }
            temp += nums[i];
            max = Math.max(temp, max);
        }
        return max;
    }
}