class Solution {
    Map<Character,Integer> ori = new HashMap<Character,Integer>();
    Map<Character,Integer> cnt = new HashMap<Character,Integer>();

    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        for(int i = 0; i < n; ++i){
            char c = t.charAt(i);
            ori.put(c,ori.getOrDefault(c,0)+1);
        }
        int ansL = -1, ansR = -1, len = Integer.MAX_VALUE;
        int l = 0, r = -1;
        while(r < m){
            ++r;
            
            if(r<m && ori.containsKey(s.charAt(r))){
                char c = s.charAt(r);
                cnt.put(c,cnt.getOrDefault(c,0)+1);
            }
            while(check()&&r<m&&l<=r){
                if(r-l+1<len){
                    len = r-l+1;
                    ansL = l;
                    ansR = l+len;
                }
                if(ori.containsKey(s.charAt(l))){
                    char c1 = s.charAt(l);
                    cnt.put(c1,cnt.getOrDefault(c1,0)-1);
                }
                ++l;
            }
        }
        return ansL==-1?"":s.substring(ansL,ansR);
    }
    public boolean check(){
        for(Map.Entry<Character,Integer> e: ori.entrySet()){
            if(e.getValue()>cnt.getOrDefault(e.getKey(),0)){
                return false;
            }
        }
        return true;
    }
}