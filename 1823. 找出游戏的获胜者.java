class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> participants = new ArrayList<Integer>();
        for(int i = 0; i < n; ++i)participants.add(i+1);
        int out = 0,pos = 0;
        while(participants.size()>1){
            out = (pos+k-1)%participants.size();
            participants.remove(out);
            pos = out;
        }
        return participants.get(0);
    }
}