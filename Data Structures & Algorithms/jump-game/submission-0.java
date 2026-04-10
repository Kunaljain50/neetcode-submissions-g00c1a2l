class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        return dfs(0, n-1, nums);
    }

    public boolean dfs(int idx, int n, int[] nums) {
        if(idx >= n) {
            return true;
        }
        int end = idx + nums[idx];
        for(int i = idx + 1; i<=end; i++) {
            if(dfs(i, n, nums)) {
                return true;
            }
        }
        return false;
    }
}
