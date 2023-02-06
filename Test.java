public class Test {
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

    public static void main(String[] args) {
        int[] nums;
        nums = new int[] { 3, 2, 1, 5, 6, 4 };
        int n = nums.length;
        int p;
        int s = 0;
        int e = n - 1;
        System.out.println(randomQuickPivot(nums, s, e, 0));
        for (int num : nums)
            System.out.println(num);
    }
}