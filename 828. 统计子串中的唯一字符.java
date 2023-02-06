class Solution {
    public int uniqueLetterString(String s) {
        HashMap<Character,ArrayList<Integer>> pos = new HashMap<Character,ArrayList<Integer>>();
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(!pos.containsKey(c)){
                pos.put(c,new ArrayList<Integer>());
                pos.get(c).add(-1);
            }
            pos.get(c).add(i);
        }
        int res = 0;
        for(Map.Entry<Character,ArrayList<Integer>> e : pos.entrySet()){
            ArrayList<Integer> arr = e.getValue();
            arr.add(s.length());
            for(int i = 1; i < arr.size() -1; ++i){
                res+=(arr.get(i)-arr.get(i-1))*(arr.get(i+1)-arr.get(i));
            }
        }
        return res;
    }
}