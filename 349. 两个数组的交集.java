class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> occ = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int i : nums1) {
            occ.add(i);
        }
        for (int j : nums2) {
            if (occ.contains(j))
                res.add(j);
        }
        int[] ans = new int[res.size()];
        int index = 0;
        for (int i : res) {
            ans[index] = i;
            ++index;
        }
        return ans;
    }
}