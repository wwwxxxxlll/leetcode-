class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int step = 0;
        int end = 0;
        int maxpos = 0;
        for(int i =0; i < n-1;++i){
            maxpos = Math.max(maxpos,i+nums[i]);
            if(i == end){
                end = maxpos;
                ++step;
            }
        }
        return step;
    }
}