class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int[] row : dp) Arrays.fill(row, -1);

        return memo(prices, n, 0, 0, dp);
    }

    public static int memo(int[] prices, int n, int i, int buy, int[][] dp) {

        if(i >= n) return 0;
        if (dp[i][buy] != -1) return dp[i][buy];

        if(buy == 0) {
            return Math.max(0 + memo(prices, n, i+1, 0, dp),
             -1 * prices[i] + memo(prices, n, i+1, 1, dp));
        } else {
            return Math.max(0 + memo(prices, n, i+1, 1, dp),
             prices[i] + memo(prices, n, i+2, 0, dp));
        }
    }
}
