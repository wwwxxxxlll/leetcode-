class Solution {
    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static int randomQuickPivot(int[] nums, int start, int end, int pivot) {
        int i = start;
        int j = end;
        int p = nums[pivot];
        while (i < j) {
            while (i < j && nums[j] <= p) {
                --j;
            }
            while (i < j && nums[i] >= p) {
                ++i;
            }
            if (i == j) {
                swap(nums, i, pivot);
                return i;
            }
            swap(nums, i, j);
        }
        return i;
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int p;
        int s = 0;
        int e = n - 1;
        while (true) {
            p = randomQuickPivot(nums, s, e, s);
            if (p == k - 1) {
                return nums[p];
            } else {
                if (p > k - 1) {
                    e = p - 1;
                } else {
                    s = p + 1;
                }
            }
        }
    }
}