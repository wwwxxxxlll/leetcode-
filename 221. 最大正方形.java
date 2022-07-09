class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ansg = 0;
        
        for(int i = 0; i < m; ++i){
            for(int j = 0; j <n; ++j){
                if(i ==0 || j == 0){
                    if(matrix[i][j] == '1')
                        dp[i][j] = 1;
                }
                else{
                    int l1 = dp[i-1][j];
                    int l2 = dp[i-1][j-1];
                    int l3 = dp[i][j-1];
                    if(matrix[i][j] == '1'){
                        ++l1;
                        ++l2;
                        ++l3;
                        dp[i][j] = Math.min(l1,Math.min(l2,l3));
                    }
                }
                if(dp[i][j] > ansg)
                    ansg = dp[i][j];
            }
        }
        int ans = ansg*ansg;
        return ans;
    }
}