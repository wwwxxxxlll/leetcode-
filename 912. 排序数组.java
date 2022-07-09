class Solution {
    public int[] sortArray(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    public void qsort(int[] nums, int l, int r) {
        if (l < r) {
            int n = randomizedPartition(nums, l, r);
            qsort(nums, l, n - 1);
            qsort(nums, n + 1, r);
        }
    }
    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, l, i);
        return quicksort(nums, l, r);
    }
    public int quicksort(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && nums[j] >= pivot)
                --j;
            while (i < j && nums[i] <= pivot)
                ++i;
            if (j > i)
                swap(nums, i, j);
        }
        swap(nums, start, i);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}