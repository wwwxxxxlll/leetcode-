class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        if(matrix.size() == 0 || matrix.size() != matrix[0].size()) {
            return;
        }
        int nums = matrix.size();
        int times = 0;
        while(times <= (nums >> 1)){
            int len = nums - (times << 1);
            for(int i = 0; i < len - 1; ++i){
                int temp = matrix[times][times + i];
                matrix[times][times + i] = matrix[times + len - i - 1][times];
                matrix[times + len - i - 1][times] = matrix[times + len - 1][times + len - i - 1];
                matrix[times + len - 1][times + len - i - 1] = matrix[times + i][times + len - 1];
                matrix[times + i][times + len - 1] = temp;
            }
            ++times;
        }
    }
};