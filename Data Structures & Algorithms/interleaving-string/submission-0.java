class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int i = s1.length();
        int j = s2.length();
        int k = s3.length();

        return memo(s1, s2, s3, i-1, j-1, k-1);
    }

    public boolean memo(String s1, String s2, String s3, int i, int j, int k) {

        if (i < 0 && j < 0 && k < 0) return true;

        if(i>= 0 && s1.charAt(i) == s3.charAt(k)) {
            return memo(s1, s2, s3, i-1, j, k-1);
        }

        if(j>= 0 && s2.charAt(i) == s3.charAt(k)) {
            return memo(s1, s2, s3, i, j-1, k-1);
        }

        return false;
    }
}
