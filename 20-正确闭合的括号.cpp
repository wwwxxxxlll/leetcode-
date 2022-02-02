class Solution {
public://只判断右括号，使用栈存储左括号，只要遇到不匹配的情况或栈中没有内容就返回，最后判断栈是否为空，避免字符串中只有左括号
    // unordered_map与map不同在于map使用树结构存储，unordered_map内部不使用这种结构
    bool isValid(string s) {
        int n = s.size();
        if (n % 2 == 1) {
            return false;
        }
        unordered_map<char, char> pairs = {
            {')', '('},
            {']', '['},
            {'}', '{'}
        };
        stack<char> stk;
        for(char ch:s){
            if( pairs.count(ch)){
                if(stk.empty() || stk.top() != pairs[ch]){
                    return false;
                }
                stk.pop();
            }
            else
                stk.push(ch);
        }
        return stk.empty();
    }
};
