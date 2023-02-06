class Solution {
    public int totalFruit(int[] fruits) {
        int t1 = -1, t2 = -1, n1, n2;
        n1 = 0;
        n2 = 0;
        int left = 0;
        int right = 0;
        int cnt = 0;
        int max = 0;
        while (right < fruits.length) {
            if (cnt < 2) {
                if (cnt == 0) {
                    max = Math.max(max, right - left + 1);
                    t1 = fruits[right++];
                    n1 = 1;
                    cnt++;
                } else {
                    if (fruits[right] == t1) {
                        ++n1;
                        max = Math.max(max, right - left + 1);
                        right++;
                    } else {
                        max = Math.max(max, right - left + 1);
                        t2 = fruits[right++];
                        ++n2;
                        cnt++;
                    }
                }
            } else {
                if (t1 == fruits[right]) {
                    max = Math.max(max, right - left + 1);
                    n1++;
                    right++;
                    continue;
                }
                if (t2 == fruits[right]) {
                    max = Math.max(max, right - left + 1);
                    n2++;
                    right++;
                    continue;
                }
                while (left <= right) {
                    if (t1 == fruits[left]) {
                        n1--;
                        left++;
                        if (n1 == 0) {
                            t1 = fruits[right++];
                            n1 = 1;
                            break;
                        }
                    }
                    if (t2 == fruits[left]) {
                        n2--;
                        left++;
                        if (n2 == 0) {
                            t2 = fruits[right++];
                            n2 = 1;
                            break;
                        }
                    }
                }
            }
        }
        return max;
    }
}