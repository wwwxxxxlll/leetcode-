class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            for (int j : nums2) {
                hs.put(i + j, hs.getOrDefault(i + j, 0) + 1);
            }
        }
        int res = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                res += hs.getOrDefault(-i - j, 0);
            }
        }
        return res;
    }
}