class Solution {
    public boolean dfs(int[] nums, int begin, int curSum, int k, int target, boolean[] visited) {

        if (k == 1)
            return true;
        if (curSum == target)
            return dfs(nums, nums.length - 1, 0, k - 1, target, visited);
        for (int i = begin; i >= 0; i--) {
            if (nums[i] > target)
                return false;
            else {
                if (visited[i])
                    continue;
                if (curSum + nums[i] > target)
                    continue;
                visited[i] = true;
                if (dfs(nums, i - 1, curSum + nums[i], k, target, visited))
                    return true;
                visited[i] = false;
                while (i > 0 && nums[i] == nums[i - 1]) {
                    i--;
                }
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        if (k > n)
            return false;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int target = sum % k;
        if (target != 0)
            return false;
        target = sum / k;
        boolean[] visited = new boolean[n];
        Arrays.sort(nums);

        return dfs(nums, n - 1, 0, k, target, visited);
    }
}