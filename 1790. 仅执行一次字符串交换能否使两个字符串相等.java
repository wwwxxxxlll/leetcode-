class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        int pos1 = -1, pos2 = -1;
        int cnt = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) == s2.charAt(i))
                continue;
            if (pos1 == -1) {
                pos1 = i;
            } else {
                if (cnt >= 2) {
                    return false;
                } else {
                    pos2 = i;
                }
            }
            cnt++;
        }
        return cnt == 2 && s1.charAt(pos1) == s2.charAt(pos2) && s1.charAt(pos2) == s2.charAt(pos1);
    }
}