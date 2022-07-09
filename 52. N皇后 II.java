class Solution {
    int sum;

    public int totalNQueens(int n) {
        this.sum = 0;
        HashSet<Integer> column = new HashSet<Integer>();
        HashSet<Integer> d1 = new HashSet<Integer>();
        HashSet<Integer> d2 = new HashSet<Integer>();
        backtrack(n, column, d1, d2, 0);
        return this.sum;
    }

    public void backtrack(int n, Set<Integer> column, Set<Integer> d1, Set<Integer> d2, int la) {
        if (la == n)
            this.sum += 1;
        else {
            for (int i = 0; i < n; i++) {
                if (column.contains(i))
                    continue;
                int dd1 = la - i, dd2 = la + i;
                if (d1.contains(dd1))
                    continue;
                if (d2.contains(dd2))
                    continue;
                column.add(i);
                d1.add(dd1);
                d2.add(dd2);
                backtrack(n, column, d1, d2, la + 1);
                column.remove(i);
                d1.remove(dd1);
                d2.remove(dd2);
            }
        }
    }
}