class MinStack {

    private Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new int[]{val, val});
            return;
        }

        int[] pop = stack.peek();
        if(pop[1] > val) {
            stack.push(new int[]{val, val});
            return;
        }
        stack.push(new int[]{val, pop[1]});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
