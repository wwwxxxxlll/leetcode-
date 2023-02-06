class Solution {
    public int maxChunksToSorted(int[] arr) {
        int min = arr.length;
        int max = -1;
        int ans = 0;
        for(int i =0, j =0; i < arr.length; ++i){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
            if(i == max && j == min){
                ++ans;
                j = i+1;
                min = i+1;
                max = -1;
            }
        }
        return ans;
    }
}