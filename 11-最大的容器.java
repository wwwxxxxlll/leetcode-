class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int n = height.length;
        int less = height[l]>height[r] ? height[r] : height[l];
        int max = 0;
        while(l<r){
            max = (r - l)*less>max ?(r - l)*less:max;
            if(height[l]<height[r])
                l++;
            else
                r--; 
            less = height[l]>height[r] ? height[r] : height[l];
        }
        return max;
    }
}