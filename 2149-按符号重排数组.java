class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int n1 = n/2;
        int[] pri = new int[n1];
        int ip = 0; 
        int im = 0;
        int[] minu = new int[n1];
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                pri[ip] = nums[i];
                ++ip;
            }
            else{
                minu[im] = nums[i];
                ++im;
            }
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i+=2){
            ans[i] = pri[i/2];
            ans[i+1] = minu[i/2];
        }
        return ans;
    }
}