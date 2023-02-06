
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        StringBuilder str = new StringBuilder(s2);
        str.append(s2);
        return str.toString().indexOf(s1) != -1;
    }
}