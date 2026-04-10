class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(0, n-1, nums, dp);
    }

    public static int dfs(int idx, int n, int[] nums, int[] dp) {
        if(idx >= n) {
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        int end = idx + nums[idx];
        int jump = Integer.MAX_VALUE;
        for(int i = idx+1; i<=end; i++) {
            jump = Math.min(jump, 1 + dfs(i, n, nums, dp));
        }

        return dp[idx] = jump;
    }
}
