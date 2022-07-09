class Solution {
    public int myAtoi(String s) {
        String sn = s.trim();
        boolean flag = false;
        int i = 0;
        if (sn.length() == 0)
            return 0;
        if (sn.charAt(0) == '-') {
            i = 1;
            flag = true;
        } else if (sn.charAt(0) == '+') {
            i = 1;
            flag = false;
        }
        long temp = 0;
        int ans = 0;
        long neg;
        if (i != 0)
            neg = flag ? (long) Integer.MAX_VALUE + 1 : Integer.MAX_VALUE;
        else
            neg = Integer.MAX_VALUE;
        for (; i < sn.length(); ++i) {
            if ((sn.charAt(i) - '0') < 0 || (sn.charAt(i) - '0') > 9)
                break;
            temp *= 10;
            temp += (sn.charAt(i) - '0');
            if (temp > neg) {
                temp = neg;
                break;
            }
        }
        if (flag)
            temp *= -1;
        ans = (int) temp;
        return ans;

    }
}