class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n <= 1)
            return intervals;
        else{
            Arrays.sort(intervals,(int[] l1, int[] l2)->{return l1[0] - l2[0];});
            int l = intervals[0][0];
            int r = intervals[0][1];
            List<int[]> ans = new ArrayList<int[]>();
            for(int i = 1;i<n;i++){
                if(r>=intervals[i][0]){
                    r = Math.max(r,intervals[i][1]);
                }
                else{
                    ans.add(new int[]{l,r});
                    l = intervals[i][0];
                    r = intervals[i][1];
                }
            }
            ans.add(new int[]{l,r});
            return ans.toArray(new int[ans.size()][]);
        }
    }
}