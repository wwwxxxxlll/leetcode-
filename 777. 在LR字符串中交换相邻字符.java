class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length() || !start.replaceAll("X", "").equals(end.replaceAll("X", "")))
            return false;
        int j = 0;
        for (int i = 0; i < start.length(); ++i) {
            if (start.charAt(i) == 'X')
                continue;
            while (end.charAt(j) == 'X')
                ++j;
            if ((i < j && end.charAt(j) == 'L') || (i > j && end.charAt(j) == 'R'))
                return false;
            ++j;
        }
        return true;
    }
}