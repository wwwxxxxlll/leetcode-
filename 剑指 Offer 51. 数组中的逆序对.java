class Solution {
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }
        int[] temp = new int[len];
        return getReversePairs(nums, 0, len - 1, temp);
    }

    public static int getReversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = getReversePairs(nums, left, mid, temp);
        int rightCount = getReversePairs(nums, mid + 1, right, temp);
        if (nums[mid] < nums[mid + 1]) {
            return rightCount + leftCount;
        }
        return rightCount + leftCount + merge(nums, left, right, mid, temp);
    }

    public static int merge(int[] nums, int left, int right, int mid, int[] temp) {
        for (int i = left; i <= right; ++i) {
            temp[i] = nums[i];
        }
        int i = left, j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; ++k) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else {
                if (j == right + 1) {
                    nums[k] = temp[i++];
                } else {
                    if (temp[i] > temp[j]) {
                        nums[k] = temp[j++];
                        count += mid + 1 - i;
                    } else {
                        nums[k] = temp[i++];
                    }
                }
            }
        }
        return count;
    }

}