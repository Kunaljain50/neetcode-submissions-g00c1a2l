class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int farthest = 0;
        int jump = 0;

        for(int i = 0; i<n-1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if(i == end) {
                end = farthest;
                jump++;
            }
        }

        return jump;
    }

    public static int dfs(int idx, int n, int[] nums, int[] dp) {
        if(idx >= n) {
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        int end = idx + nums[idx];
        int jump = 1000000;
        for(int i = idx+1; i<=end; i++) {
            jump = Math.min(jump, 1 + dfs(i, n, nums, dp));
        }

        return dp[idx] = jump;
    }
}
