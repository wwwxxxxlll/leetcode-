class Solution {
public://双指针，如果只从第一个位置开始会丢失部分情况，所以第一个指针也需要放在循环中遍历，使用set存储出现情况
    int lengthOfLongestSubstring(string s) {
        int l = 0, r = 0;
        unordered_set<char> occ;
        int n = s.size();
        int ans = 0;
        for( ;l<n;l++){
            if(l != 0){
                occ.erase(s[l - 1]);
            }
            while(r<n&&!occ.count(s[r])){
                occ.insert(s[r]);
                r++;
            }
            ans = max(ans, r - l);
        }
        return ans;
    }
};
