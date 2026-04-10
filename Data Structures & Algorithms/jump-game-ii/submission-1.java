class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        return dfs(0, n-1, nums);
    }

    public static int dfs(int idx, int n, int[] nums) {
        if(idx == n) {
            return 0;
        }

        int end = idx + nums[idx];
        int jump = Integer.MAX_VALUE;
        for(int i = idx+1; i<=end; i++) {
            jump = Math.min(jump, 1 + dfs(i, n, nums));
        }

        return jump;
    }
}
