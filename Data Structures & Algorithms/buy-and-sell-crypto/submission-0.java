class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int buy = arr[0];
        int profit = 0;

        for(int i=1; i<n; i++) {

            if(buy > arr[i]) {
                buy = arr[i];
            } else {
                int temp = arr[i] - buy;
                profit = Math.max(profit, temp);
            }
        }

        return profit;
    }
}
