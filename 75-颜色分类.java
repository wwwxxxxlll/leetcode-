class Solution {//三指针的情况下指针经过的位置未必完成了排序
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n-1;
        if(n < 2)
            return;
        for(int i = 0; i <= p2; i++){
            while(p2>=i && nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2; 
            }
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}