class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];

        for(int[] it : dp) Arrays.fill(it, -1);
        return memo(text1, text2, m-1, n-1, dp);
    }

    public int memo(String str1, String str2, int i, int j, int[][] dp) {

        if(i < 0 || j<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j] = 1 + memo(str1, str2, i-1, j-1, dp);
        } else {
            return dp[i][j] = Math.max(memo(str1, str2, i-1, j, dp), memo(str1, str2, i, j-1, dp));
        }
    }
}
