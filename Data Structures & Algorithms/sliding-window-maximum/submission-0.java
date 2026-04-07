class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];

        int l = 0;
        int h = k;
        int count = 0;
        
        while (h<=n) {
            int max = Integer.MIN_VALUE;
            for(int i = l; i<h; i++) {
                max = Math.max(nums[i], max);
            }
            ans[count++] = max;
            l++;
            h++;
        }

        return ans;
    }
}
