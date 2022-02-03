class Solution {
public:
    int maxArea(vector<int>& height) {//由于本题特性，导致只需要一次遍历全部位置即可，不需要遍历全部起点，如5-最长回文数组
        int l = 0, r = height.size() - 1;
        int h1 = 0;
        int max_s = 0;
        while(l<r){
            h1 = min(height[r],height[l]);
            max_s = max(h1*(r-l),max_s);
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return max_s;
    }
};
