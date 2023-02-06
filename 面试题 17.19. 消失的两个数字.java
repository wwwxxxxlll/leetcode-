class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length;
        int bit = 0;
        int cur = 0;
        int diff = 1;
        for (int i = 2; i <= n + 2; ++i) {
            diff ^= i;
        }
        for (int i = 0; i < n; ++i) {
            diff ^= nums[i];
        }
        bit = diff & -diff;
        int ans = 0;
        for (int i = 1; i <= n + 2; ++i) {
            if ((bit & i) != 0)
                ans ^= i;
        }
        for (int x : nums) {
            if ((bit & x) != 0)
                ans ^= x;
        }
        return new int[] { ans, diff ^ ans };
    }
}