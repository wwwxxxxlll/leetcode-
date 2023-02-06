class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> access = new HashMap<String, Integer>();
        for (String s : cpdomains) {
            String[] temp = s.split(" ");
            int times = Integer.parseInt(temp[0]);
            int t = access.getOrDefault(temp[1], 0);
            access.put(temp[1], t + times);
            for (int i = 1; i < temp[1].length(); ++i) {
                if (temp[1].charAt(i - 1) == '.') {
                    int t1 = access.getOrDefault(temp[1].substring(i, temp[1].length()), 0);
                    access.put(temp[1].substring(i, temp[1].length()), t1 + times);
                }
            }
        }
        ArrayList<String> ans = new ArrayList<String>();
        for (String key : access.keySet()) {
            StringBuilder t = new StringBuilder();
            t.append(String.valueOf(access.get(key)));
            t.append(" ");
            t.append(key);
            ans.add(t.toString());
        }
        return ans;
    }
}