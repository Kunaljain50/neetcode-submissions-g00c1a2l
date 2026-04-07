class Solution {
    public int evalRPN(String[] arr) {
        Stack<Integer> stack = new Stack<>();

        int n = arr.length;

        for(int i = 0; i<n; i++) {
            if(arr[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (arr[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (arr[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (arr[i].equals("/")) {
                stack.push(stack.pop() / stack.pop());
            } else {
                stack.push(Integer.parseInt(arr[i]));
            }
        }

        return stack.pop();
    }
}
