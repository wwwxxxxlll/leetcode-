class Solution {
    public int[] threeEqualParts(int[] arr) {
        int num1 = 0;
        int n = arr.length;
        for (int x : arr) {
            if (x == 1) {
                num1++;
            }
        }
        if (num1 % 3 != 0) {
            return new int[] { -1, -1 };
        }
        if (num1 == 0) {
            return new int[] { 0, 2 };
        }
        int num = num1 / 3;
        int first = 0, second = 0, third = 0;
        int len;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == 1) {
                if (cnt == 0) {
                    first = i;
                }
                if (cnt == num) {
                    second = i;
                }
                if (cnt == 2 * num) {
                    third = i;
                }
                cnt++;
            }
        }
        len = n - third - 1;
        if (first + len < second && second + len < third) {
            int i = 0;
            while (third + i < n) {
                if (arr[first + i] != arr[second + i] || arr[second + i] != arr[third + i]) {
                    return new int[] { -1, -1 };
                }
                i++;
            }
            return new int[] { first + len, second + len + 1 };
        }
        return new int[] { -1, -1 };
    }
}