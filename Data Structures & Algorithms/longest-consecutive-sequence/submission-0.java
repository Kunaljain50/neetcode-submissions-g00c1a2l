class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int it : nums) {
            set.add(it);
        }

        int res = Integer.MIN_VALUE;

        for(int i : set) {
            if(!set.contains(i-1)) {
                int currNum = i;
                int currStreak = 0;

                while(set.contains(currNum)) {
                    currNum = currNum+1;
                    currStreak++;
                }

                res = Math.max(res, currStreak);
            }
        }

        return res;
    }
}
