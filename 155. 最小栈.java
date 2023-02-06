class MinStack {
    private LinkedList<Integer> s1;
    private LinkedList<Integer> s2;

    public MinStack() {
        s1 = new LinkedList<Integer>();
        s2 = new LinkedList<Integer>();
        s2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        int min = s2.peek();
        if (min < val) {
            s2.push(min);
        } else {
            s2.push(val);
        }
        s1.push(val);
    }

    public void pop() {
        s2.pop();
        s1.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */