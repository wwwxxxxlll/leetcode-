class Solution {
    public boolean canChange(String start, String end) {
        if (start.length() != end.length() || !start.replaceAll("_", "").equals(end.replaceAll("_", "")))
            return false;
        int j = 0;
        for (int i = 0; i < start.length(); ++i) {
            if (start.charAt(i) == '_')
                continue;
            while (end.charAt(j) == '_')
                ++j;
            if ((i < j && end.charAt(j) == 'L') || (i > j && end.charAt(j) == 'R'))
                return false;
            ++j;
        }
        return true;
    }
}