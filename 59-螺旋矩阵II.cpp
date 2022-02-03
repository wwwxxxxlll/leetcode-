class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> v(n,vector<int>(n, 0));
        int startx = 0, starty = 0;
        int offset = 1;
        int mid = n/2;
        int loop = n/2;
        int count = 1;
        int i, j;
        while(loop--){
            for (j = starty; j < starty + n - offset; j++) {
                v[startx][j] = count++;
            }
            for (i = startx; i < startx + n - offset; i++) {
                v[i][j] = count++;
            }
            for (; j > starty; j--) {
                v[i][j] = count++;
            }
            for (; i > startx; i--) {
                v[i][j] = count++;
            }      

            startx++;
            starty++;

            offset += 2;
        }
        if(n%2==1)
            v[mid][mid] = count;
        return v;
    }
};