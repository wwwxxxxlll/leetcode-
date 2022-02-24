// 注意HashMap的写法
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> temp = map.getOrDefault(key,new ArrayList<String>());
            temp.add(str);
            map.put(key,temp);
        }
        return new ArrayList<List<String>>(map.values());
    }
}