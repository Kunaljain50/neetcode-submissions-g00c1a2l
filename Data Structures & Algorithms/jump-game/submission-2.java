class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n-1;
        for(int i = n-2; i>=0; i--) {
            if((i+nums[i]) >= goal) {
                goal = i;
            }
        }

        return goal == 0;
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
