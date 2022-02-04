class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> combinations;
        if(digits.empty())
            return combinations;
        unordered_map<char, string> phoneMap{//注意unordered_map的使用，效果是哈希表
            {'2', "abc"},
            {'3', "def"},
            {'4', "ghi"},
            {'5', "jkl"},
            {'6', "mno"},
            {'7', "pqrs"},
            {'8', "tuv"},
            {'9', "wxyz"}
        };
        string combination;
        backtrack(combinations,combination,digits,0,phoneMap);
        return combinations;
    }
    void backtrack(vector<string>& combinations, string& combination, string& digits, int index, unordered_map<char, string>& phoneMap){
        if(index == digits.length()){
            combinations.push_back(combination);
            return;
        }
        else{
            string letters = phoneMap.at(digits[index]);
            for(char letter:letters){
                combination.push_back(letter);
                backtrack(combinations,combination,digits,index+1,phoneMap);//注意要在使用后将压入的字符弹出，从而使用同一个字符串存储，节省空间
                combination.pop_back();
            }
            return;
        }

    }
};