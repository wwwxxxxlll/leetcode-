class Solution {
    public String longestCommonPrefix(String[] strs) {
        char pre = ' ';
        StringBuffer ans = new StringBuffer();
        for(int l = 0;l<strs[0].length();l++){
            pre = strs[0].charAt(l);
            for(int j = 1; j < strs.length; j++){
                if(l >= strs[j].length()||strs[j].charAt(l)!=pre)
                    return ans.toString();
            }
            ans.append(pre);
        }
        return ans.toString();
    }
}