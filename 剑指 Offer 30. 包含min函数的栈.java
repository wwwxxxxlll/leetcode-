class MinStack {
    public Deque<Integer> mins, reals;

    /** initialize your data structure here. */
    public MinStack() {
        mins = new LinkedList<Integer>();
        reals = new LinkedList<Integer>();
        mins.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        reals.push(x);
        mins.push(Math.min(mins.peek(), x));
    }

    public void pop() {
        mins.pop();
        reals.pop();
    }

    public int top() {
        return reals.peek();
    }

    public int min() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */