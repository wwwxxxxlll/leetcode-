// 字符串的排列
// 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。

// 换句话说，s1 的排列之一是 s2 的 子串 。
// 示例 1：

// 输入：s1 = "ab" s2 = "eidbaooo"
// 输出：true
// 解释：s2 包含 s1 的排列之一 ("ba").
// 示例 2：

// 输入：s1= "ab" s2 = "eidboaoo"
// 输出：false

// 提示：

// 1 <= s1.length, s2.length <= 104
// s1 和 s2 仅包含小写字母
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 首先先得到两个字符串的长度
        int n = s1.length();
        int m = s2.length();
        int[] ct1 = new int[26];
        int[] ct2 = new int[26];

        // 如果s1更长，那么就直接返回false
        if (n > m)
            return false;

        for (int i = 0; i < n; i++) {
            // 第一次得到二者频率并且比较
            ct1[s1.charAt(i) - 'a']++;
            ct2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(ct1, ct2)) {
            return true;
        }

        for (int i = n; i < m; ++i) {
            ct2[s2.charAt(i) - 'a']++;
            ct2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(ct1, ct2)) {
                return true;
            }
        }
        return false;

    }

}