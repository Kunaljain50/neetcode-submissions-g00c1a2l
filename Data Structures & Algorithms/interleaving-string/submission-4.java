class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int i = s1.length();
        int j = s2.length();

        if (i + j != s3.length()) return false;

        Boolean[][] dp = new Boolean[i][j];

        return memo(s1, s2, s3, i-1, j-1, dp);
    }

    public boolean memo(String s1, String s2, String s3, int i, int j, Boolean[][] dp) {

        if (i < 0 && j < 0) return true;

        if(i >= 0 && j >= 0 && dp[i][j] != null) return dp[i][j];
        
        int k = i + j + 1;
        boolean ans = false;

        if(i>= 0 && s1.charAt(i) == s3.charAt(k)) {
            ans = ans || memo(s1, s2, s3, i-1, j, dp);
        }

        if(j>= 0 && s2.charAt(j) == s3.charAt(k)) {
            ans = ans || memo(s1, s2, s3, i, j-1, dp);
        }

        if (i >= 0 && j >= 0) dp[i][j] = ans; 
        
        return ans;
    }
}
