class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return memo(cost, n-1);
    }

    public int memo(int[] cost, int n) {
        if(n == 0) return cost[0];

        int x = Integer.MAX_VALUE;

        for(int i = 1; i<=2; i++) {
            if(n-i >= 0) {
                int jump = cost[n-i] + memo(cost, n-i);
                x = Math.min(jump, x);
            }
        }

        return x;
    }
}
