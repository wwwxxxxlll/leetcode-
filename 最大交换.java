class Solution {
    public int maximumSwap(int num) {
        int num1 = num;
        int minpos = -1, maxpos = 0;
        int m = 0;
        int midx = 0;
        int max = 0;
        int i = 0;
        ArrayList<Integer> s = new ArrayList<Integer>();
        while(num > 0){
            int t = num % 10;
            num/=10;
            if(t > max){
                max = t;
                maxpos = i;
            }else if(t < max){
                minpos = i;
                midx = maxpos;
                m = max;
            }
            s.add(t);
            ++i;
        }
        int[] nums = new int[i];
        for(int j = 0; j < i; ++j){
            nums[j] = s.get(j);
        }
        if(minpos == -1){
            return num1;
        }
        nums[midx] = nums[minpos];
        nums[minpos] = m;
        int ans = 0;
        for(int j = i-1; j >= 0; --j){
            ans*=10;
            ans+=nums[j];
        }
        return ans;
    }
}