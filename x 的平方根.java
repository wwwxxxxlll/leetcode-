// x 的平方根
// 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。

// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
class Solution {
    public int mySqrt(int x) {
        if (x == 1)
            return 1;
        int l = 1;
        int r = x;
        int ans = 0;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (guess(mid, x)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public boolean guess(int k, int x) {
        return (long) k * k <= x;
    }
}