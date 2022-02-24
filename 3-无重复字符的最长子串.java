class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> occ = new HashSet<Character>();
        int right = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(i != 0)
                occ.remove(s.charAt(i - 1));
            while(right < n && !occ.contains(s.charAt(right))){
                occ.add(s.charAt(right++));
            }
            ans = Math.max(ans,right - i);
        }
        return ans;
    }
}