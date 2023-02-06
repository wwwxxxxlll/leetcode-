class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> que = new LinkedList<Integer>();
        int pos1 = 0;
        int pos2 = 0;
        for (int i = 0, j = 0; i < pushed.length; ++i) {
            que.push(pushed[i]);
            while (!que.isEmpty() && que.peek() == popped[j]) {
                que.pop();
                ++j;
            }
        }
        return que.isEmpty();
    }
}