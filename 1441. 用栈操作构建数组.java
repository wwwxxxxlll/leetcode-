class Solution {
    public List<String> buildArray(int[] target, int n) {
        int i = 1;
        String p1 = "Push", p2 = "Pop";
        ArrayList<String> ans = new ArrayList<String>();
        for (int j = 0; j < target.length; ++j) {
            if (i == target[j]) {
                i++;
                ans.add(p1);
            } else {
                while (i != target[j]) {
                    ans.add(p1);
                    ans.add(p2);
                    i++;
                }
                ans.add(p1);
                i++;
            }
        }
        return ans;
    }
}