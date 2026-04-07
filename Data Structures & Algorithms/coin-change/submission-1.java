class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        if(amount == 0) return 0;

        int[][] dp = new int[n+1][amount+1];

        for(int[] it : dp) Arrays.fill(it, -1);
        int result = memo(coins, amount, n-1, dp);

        return result >= (int)1e9 ? -1 : result;
    }

    public int memo(int[] coins, int amount, int idx, int[][] dp) {

        if(idx == 0) {
            if(amount % coins[idx] == 0) {
                return amount / coins[idx];
            }
            return (int)1e9;
        }

        if(dp[idx][amount] != -1) return dp[idx][amount];

        int nonPick = memo(coins, amount, idx-1, dp);
        int pick = (int)1e9;

        if(amount >= coins[idx]) {
            pick = 1 + memo(coins, amount-coins[idx], idx, dp);
        }

        return dp[idx][amount] = Math.min(nonPick, pick);
    }
}
