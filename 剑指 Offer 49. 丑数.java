class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; ++i) {
            nums[i] = Math.min(nums[p2] * 2, Math.min(nums[p3] * 3, nums[p5] * 5));
            if (nums[i] == nums[p2] * 2)
                p2++;
            if (nums[i] == nums[p3] * 3)
                p3++;
            if (nums[i] == nums[p5] * 5)
                p5++;
        }
        return nums[n - 1];
    }
}