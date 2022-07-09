class Solution {
    public double myPow(double x, int n) {
        double r = x;
        double ans = 1.0;
        boolean flag = true;
        long N = n;
        if (N < 0) {
            N = -N;
            flag = false;
        }
        while (N > 0) {
            if (N % 2 == 1)
                ans *= r;
            r *= r;
            N = N / 2;
        }
        if (!flag)
            ans = 1.0 / ans;
        return ans;
    }
}