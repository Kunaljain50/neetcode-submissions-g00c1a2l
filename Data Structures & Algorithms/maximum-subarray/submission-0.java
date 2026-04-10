class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        int sum = 0;

        for(int it : nums) {
            sum+= it;
            max = Math.max(max, sum);

            if(sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
