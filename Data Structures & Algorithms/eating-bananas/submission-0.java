class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;

        for(int it : piles) {
            max = Math.max(it, max);
        }

        int start = 1;
        int end = max;

        int res = Integer.MAX_VALUE;

        while(start <= end) {

            int mid = (start + end) / 2;

            if(isCheck(piles, h, mid)) {
                res = Math.min(res, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }

    public static boolean isCheck(int[] piles, int h, int mid) {
        int sum = 0;
        for(int it : piles) {
            sum += (int) Math.ceil((double) it / (double) mid);
        }
        return sum <= h;
    }
}
