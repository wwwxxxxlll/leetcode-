class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int ax, ix, ay, iy;
        ax = 0;
        ix = Integer.MAX_VALUE;
        ay = 0;
        iy = Integer.MAX_VALUE;
        int max = 0;
        int[] ans = new int[2];
        int radius2 = radius * radius;
        for (int[] tower : towers) {
            ax = Math.max(ax, tower[0]);
            ix = Math.min(ix, tower[0]);
            ay = Math.max(ay, tower[1]);
            iy = Math.min(iy, tower[1]);
        }
        for (int i = ix; i <= ax; ++i) {
            for (int j = iy; j <= ay; ++j) {
                int signal = 0;
                for (int[] tower : towers) {
                    int distance2 = (tower[0] - i) * (tower[0] - i) +
                            (tower[1] - j) * (tower[1] - j);
                    if (distance2 <= radius2) {
                        signal += Math.floor(tower[2] / (1 + Math.sqrt(distance2)));
                    }
                }
                if (max < signal) {
                    max = signal;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}