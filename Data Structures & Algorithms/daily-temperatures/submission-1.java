class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        Stack<int[]> stack = new Stack();

        for(int i = n-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek()[0] <= arr[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? 0 : stack.peek()[1] - i;

            stack.push(new int[]{arr[i], i});
        }

        return ans;
    }
}
