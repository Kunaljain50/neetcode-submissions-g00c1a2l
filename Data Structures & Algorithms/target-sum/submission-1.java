class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        int n = nums.length;
        for(int i : nums)
            totalSum += i;

        if(totalSum < Math.abs(target))
            return 0;

        if((totalSum - target) % 2 == 1)
            return 0;

        int s2 = (totalSum - target) / 2;

        int[][] dp = new int[n][s2+1];
        for(int[] it : dp) Arrays.fill(it, -1);

        return memo(n-1, s2, nums, dp);
    }

    public static int memo(int n, int target, int[] nums, int[][] dp) {

        if(n == 0) {
            if(target == 0 && nums[0] == 0)
                return 2;

            if(target == 0 || nums[0] == target)
                return 1;

            return 0;
        }

        if(dp[n][target] != -1)
            return dp[n][target];

        int nonPick = memo(n-1, target, nums, dp);

        int pick = 0;
        if(nums[n] <= target)
            pick = memo(n-1, target-nums[n], nums, dp);

        return dp[n][target] = pick + nonPick;
    }
}
