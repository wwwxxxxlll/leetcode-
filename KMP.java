public class KMP {

    public static int[] gennxts_dp(String s) {
        int n = s.length();
        int i = 1;
        int[] nxt = new int[n];
        nxt[0] = 0;
        int temp = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(temp)) {
                ++temp;
                nxt[i] = temp;
                ++i;
            } else if (temp != 0) {
                temp = nxt[temp - 1];
            } else {
                nxt[i] = temp;
                ++i;
            }
        }
        return nxt;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaa";
        int[] nxt = gennxts_dp(s);
        for (int i = 0; i < nxt.length; i++)
            System.out.println(nxt[i]);
        return;
    }
}