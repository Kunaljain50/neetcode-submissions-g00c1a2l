class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n+1];
        for(int it : nums) {
            hash[it] = hash[it] + 1;
        }

        for(int i = 1; i <= n; i++) {
            if(hash[i] > 1) {
                return true;
            }
        }
        return false;
    }
}