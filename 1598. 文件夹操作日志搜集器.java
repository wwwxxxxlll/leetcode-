class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String str : logs) {
            if (str.equals("./")) {
                continue;
            } else {
                if (str.equals("../")) {
                    depth -= (depth == 0 ? 0 : 1);
                } else {
                    depth += 1;
                }
            }
        }
        return depth;
    }
}