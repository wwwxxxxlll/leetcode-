class Solution {
    public String arrangeWords(String text) {
        ArrayList<String> len = new ArrayList<String>();
        int n = text.length();
        StringBuffer temp = new StringBuffer();
        text = text.substring(0, 1).toLowerCase() + text.substring(1);
        String[] texts = text.split(" ");
        Arrays.sort(texts,(String str1, String str2)->str1.length()-str2.length());
        StringBuffer ans = new StringBuffer();
        temp = new StringBuffer();
        temp.append(Character.toUpperCase(texts[0].charAt(0)));
        temp.append(texts[0].substring(1,texts[0].length()));
        ans.append(temp);
        for(int i = 1; i < texts.length; i++){
            ans.append(" ");
            ans.append(texts[i]);
        }
        return ans.toString();
        
    }
}