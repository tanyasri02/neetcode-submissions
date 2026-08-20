class MinStack {
    Stack<Pair<Integer, Integer>> st = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        int min_so_far = Math.min(val, st.isEmpty() ? val : st.peek().getValue());
        st.push(new Pair<>(val, min_so_far));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().getKey();
    }
    
    public int getMin() {
        return st.peek().getValue();
    }
}
