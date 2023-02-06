class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        boolean check1 = false;
        boolean check0 = false;
        for (int i = 0; i < n; ++i) {
            if (!check1 && s.charAt(i) == '1') {
                check1 = true;
            }
            if (check1 && s.charAt(i) == '0') {
                check0 = true;
            }
            if (check1 && check0 && s.charAt(i) == '1')
                return false;
        }
        return true;
    }
}