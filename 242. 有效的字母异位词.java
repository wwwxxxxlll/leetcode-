class Solution {
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        s = String.valueOf(cs);
        t = String.valueOf(ct);
        return s.equals(t);
    }
}