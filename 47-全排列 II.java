class Solution {
    // dnmd为什么used和nums能看不出来写反了
    // 还是正常的回溯剪枝，不过剪枝方法比较精妙
    public void backtrack(List<List<Integer>> res, List<Integer> temp, boolean[] used, int[] source, int len){
        if(len == source.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i< source.length;i++){
            if(used[i] || (i>0 && !used[i - 1] && source[i] == source[i - 1]))
            {    continue;}
            temp.add(source[i]);
            used[i] = !used[i];
            backtrack(res,temp,used,source,len+1);
            used[i] = ! used[i];
            temp.remove(len);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        backtrack(ans,temp,used,nums,0);
        
        return ans;
    }
}
