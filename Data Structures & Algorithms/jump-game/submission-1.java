class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n];
        return dfs(0, n-1, nums, dp);
    }

    public boolean dfs(int idx, int n, int[] nums, Boolean[] dp) {
        if(idx >= n) {
            return true;
        }

        if(dp[idx] != null) {
            return dp[idx];
        }
        int end = idx + nums[idx];
        for(int i = idx + 1; i<=end; i++) {
            if(dfs(i, n, nums, dp)) {
                return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
}
