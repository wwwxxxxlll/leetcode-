class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx = new Integer[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            idx[i] = i;
        }
        int left = 0, right = n - 1;
        Arrays.sort(nums1);
        Arrays.sort(idx, (i, j) -> {
            return nums2[i] - nums2[j];
        });
        for (int num : nums1) {
            ans[num > nums2[idx[left]] ? idx[left++] : idx[right--]] = num;
        }
        return ans;
    }
}