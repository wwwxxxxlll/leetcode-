class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int num : nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        Set<Map.Entry<Integer,Integer>> es = hm.entrySet();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((o1,o2)->{return o1.getValue()-o2.getValue();});
        for (Map.Entry<Integer, Integer> entry : es) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}