class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int l = 0;
        int ans = 0;
        TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
        int r = 0;
        while (r < n) {
            tmap.put(nums[r], tmap.getOrDefault(nums[r], 0) + 1);
            while ((tmap.lastKey() - tmap.firstKey()) > limit) {
                tmap.put(nums[l], tmap.get(nums[l]) - 1);
                if (tmap.get(nums[l]) == 0)
                    tmap.remove(nums[l]);
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
            ++r;
        }
        return ans;
    }
}