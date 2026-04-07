class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return memo(cost, n-1, dp);
    }

    public int memo(int[] cost, int n, int[] dp) {
        if(n == 0 || n == 1) return cost[n];
        if(dp[n] != -1) return dp[n];

        int x = Integer.MAX_VALUE;

        for(int i = 1; i<=2; i++) {
            if(n-i >= 0) {
                int jump = cost[n-i] + memo(cost, n-i, dp);
                x = Math.min(jump, x);
            }
        }

        return dp[n] = x;
    }
}
