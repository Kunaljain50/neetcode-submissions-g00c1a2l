class Solution {
    public boolean isPalindrome(String s) {
        String res = "";

        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(isAlpha(ch)) {
                res += Character.toLowerCase(ch);
            } else if (isNumeric(ch)) {
                res += ch;
            }
        }

        int i = 0;
        int j = res.length()-1;

        while(i<j) {
            if(res.charAt(i) != res.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isAlpha(char ch) {
        return Character.isLetter(ch);
    }

    public static boolean isNumeric(char ch) {
        return Character.isDigit(ch);
    }
}
