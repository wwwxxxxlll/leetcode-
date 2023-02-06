class Solution {
    public int[] finalPrices(int[] prices) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        LinkedList<Integer> pos = new LinkedList<Integer>();
        int n = prices.length;
        int k = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && stack.peek() >= prices[i]) {
                ans[pos.pop()] = stack.pop() - prices[i];
            }
            stack.push(prices[i]);
            pos.push(i);
        }
        while (!stack.isEmpty()) {
            ans[pos.pop()] = stack.pop();
        }
        return ans;
    }
}