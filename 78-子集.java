class Solution {
    ArrayList<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>(); 
    public void backtrack(int[] nums, int len){
        if(len == nums.length){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(nums[len]);
        backtrack(nums,len+1);
        temp.remove(temp.size() - 1);
        backtrack(nums,len+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return ans;
    }
}