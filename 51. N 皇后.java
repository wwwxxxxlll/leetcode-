class Solution {
    public List<List<String>> solveNQueens(int n) {
        HashSet<Integer> column = new HashSet<Integer>();
        HashSet<Integer> d1 = new HashSet<Integer>();
        HashSet<Integer> d2 = new HashSet<Integer>();
        int[] queens = new int[n];
        List<List<String>> ans = new ArrayList<List<String>>();
        Arrays.fill(queens, -1);
        BackTrack(n,ans,queens,column,d1,d2,1);
        return ans;
    }
    public void BackTrack(int n, List<List<String>> ans, int[] queens, Set<Integer> column, Set<Integer> d1, Set<Integer> d2, int la){
        if(la == n+1){
            List<String> temp = Drawboard(queens,n);
            ans.add(temp);
            return;
        }
        else{
            for(int i = 0; i < n; i++){
                int dd1 = la-i;
                int dd2 = la+i;
                if(d1.contains(dd1))
                    continue;
                if(d2.contains(dd2))
                    continue;
                if(column.contains(i))
                    continue;
                d1.add(dd1);
                d2.add(dd2);
                column.add(i);
                queens[la-1] = i;
                BackTrack(n,ans,queens,column,d1,d2,la+1);
                queens[la-1] = -1;
                d1.remove(dd1);
                d2.remove(dd2);
                column.remove(i);
            }
        }
    }
    public List<String> Drawboard(int[] queens, int n){
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}