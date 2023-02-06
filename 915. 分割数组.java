class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] dmax = new int[n];
        int[] dmin = new int[n];
        dmin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            dmin[i] = nums[i];
            if (nums[i] >= dmin[i + 1]) {
                dmin[i] = dmin[i + 1];
            }
        }
        int max = -1;
        for (int i = 0; i < n - 1; ++i) {
            max = Math.max(max, nums[i]);
            if (dmin[i + 1] >= max) {
                return i + 1;
            }
        }
        return -1;
    }
}