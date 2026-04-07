class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[] arr1 = new int[n-1];
        int[] arr2 = new int[n-1];

        for(int i = 0; i<n-1; i++) {
            arr1[i] = nums[i];
        }

        for(int i = 1; i<n; i++) {
            arr1[i-1] = nums[i];
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(memo(arr1, arr1.length-1, dp1), memo(arr2, arr2.length-1, dp2));
    }

    public int memo(int[] nums, int n, int[] dp) {
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        
        int pick = nums[n] + memo(nums, n-2, dp);
        int nonPick = memo(nums, n-1, dp);

        return dp[n] = Math.max(pick, nonPick);
    }
}
