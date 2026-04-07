class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] it : dp) Arrays.fill(it, -1);
        return memo(amount, coins, n-1, dp);
    }

    public int memo(int amount, int[] coins, int n, int[][] dp) {

        if(n == 0) {
            if (amount % coins[0] == 0) return 1;
            return 0;
        }

        if (amount == 0) return 1;

        if(dp[n][amount] != -1) return dp[n][amount];
        
        int nonPick = memo(amount, coins, n-1, dp);

        int pick = 0;
        if(amount >= coins[n]) {
            pick = memo(amount - coins[n], coins, n, dp);
        }

        return dp[n][amount] = pick + nonPick;
    }
}
