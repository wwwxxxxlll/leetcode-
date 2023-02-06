class Solution {
    public int scoreOfParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(0);
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '('){
                stack.push(0);
            }else{
                int v = stack.pop();
                int temp = stack.pop() + Math.max(2*v,1);
                stack.push(temp);
            }
        }
        return stack.peek();
    }
}