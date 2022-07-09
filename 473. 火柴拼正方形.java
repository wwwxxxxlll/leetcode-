class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        int n = matchsticks.length;
        if (n < 4)
            return false;
        for (int match : matchsticks) {
            sum += match;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int target = sum / 4;
        boolean[] visited = new boolean[n];
        Arrays.sort(matchsticks);
        return dfs(matchsticks, 0, 4, target, n - 1, visited);
    }

    public boolean dfs(int[] matchsticks, int curSum, int k, int target, int begin, boolean[] visited) {
        if (k == 1)
            return true;
        if (curSum == target) {
            return dfs(matchsticks, 0, k - 1, target, matchsticks.length - 1, visited);
        }
        for (int i = begin; i >= 0; i--) {
            if (matchsticks[i] > target)
                return false;
            else {
                if (!visited[i]) {
                    if (curSum + matchsticks[i] > target)
                        continue;
                    visited[i] = true;
                    if (dfs(matchsticks, curSum + matchsticks[i], k, target, i - 1, visited))
                        return true;
                    visited[i] = false;
                } else {
                    continue;
                }
                while (i > 0 && matchsticks[i] == matchsticks[i - 1]) {
                    i--;
                }
            }
        }
        return false;
    }
}