class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int[] it : dp) Arrays.fill(it, -1);
        return memo(m-1, n-1, dp);
    }

    public static int memo(int m, int n, int[][] dp) {

        if(m == 0 && n == 0) {
            return 1;
        }

        if(m < 0 || n<0) {
            return 0;
        }

        if(dp[m][n] != -1) return dp[m][n];

        int left = memo(m, n-1, dp);
        int top = memo(m-1, n, dp);

        return dp[m][n] = left + top;
    }
}
