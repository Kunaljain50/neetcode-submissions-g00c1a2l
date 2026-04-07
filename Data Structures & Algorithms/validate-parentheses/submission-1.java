class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<n; i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // if (stack.isEmpty()) {
                //     return false;
                // }
                Character popEle = stack.pop();
                if(popEle == '(' && c != ')') {
                    return false;
                } else if (popEle == '{' && c != '}') {
                    return false;
                } else if (popEle == '[' && c != ']') {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
