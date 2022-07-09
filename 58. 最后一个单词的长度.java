class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int leng = 0;
        int end = n-1;
        while(s.charAt(end) == ' ')end--;
        for(int i = end; i>=0; --i){
            if(s.charAt(i) != ' '){
                ++leng;
            }
            else{
                break;
            }
        }
        return leng;
    }
}