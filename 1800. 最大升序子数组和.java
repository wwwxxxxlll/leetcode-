class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int max = 0;
        int prev = 0;
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                sum = prev + nums[i];
                prev = sum;
                max = Math.max(sum, max);
                continue;
            }
            if (nums[i] > nums[i - 1]) {
                sum = prev + nums[i];
                prev = sum;
                max = Math.max(sum, max);
            } else {
                sum = nums[i];
                prev = sum;
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}