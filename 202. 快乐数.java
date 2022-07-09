class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (sum == 1)
                return true;
            if (hs.contains(sum))
                return false;
            hs.add(sum);
            n = sum;
        }
    }
}