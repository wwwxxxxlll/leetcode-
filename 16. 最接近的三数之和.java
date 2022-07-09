class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int l, r, temp;
        Arrays.sort(nums);
        int off = Integer.MAX_VALUE;
        int ans = 0;
        int toff = 0;
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            temp = target - nums[i];
            l = i + 1;
            r = n - 1;
            while (l < r) {
                if (nums[l] + nums[r] == temp)
                    return target;
                toff = Math.abs(temp - nums[l] - nums[r]);
                if (toff < off) {
                    off = toff;
                    ans = nums[i] + nums[l] + nums[r];
                }
                if (nums[l] + nums[r] < temp)
                    ++l;
                else
                    --r;
            }
        }
        return ans;
    }
}