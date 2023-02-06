class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            int cnt1 = cnt.get(a);
            int cnt2 = cnt.get(b);
            return cnt1 == cnt2 ? b - a : cnt1 - cnt2;
        });
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}