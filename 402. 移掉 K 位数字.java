class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        int ik = k;
        if (k >= n)
            return "0";
        else {
            char[] cn = num.toCharArray();
            Stack<Character> st = new Stack<Character>();
            for (int i = 0; i < n; ++i) {
                while (k > 0 && !st.isEmpty() && cn[i] < st.peek()) {
                    --k;
                    st.pop();
                }
                st.push(cn[i]);
            }
            int l = st.size();
            for (int i = l - 1; i >= 0; --i) {
                cn[i] = st.pop();
            }
            int al = n - ik;
            StringBuilder ans = new StringBuilder();
            boolean flag = true;
            for (int i = 0; i < al; ++i) {
                if (cn[i] == '0' && flag)
                    continue;
                else {
                    flag = false;
                    ans.append(cn[i]);
                }
            }
            if (ans.length() == 0)
                return "0";
            return ans.toString();
        }
    }
}