class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = n-1;
        int end = 0;
        int total = gas[start] - cost[start];

        while(start > end) {
            if(total < 0) {
                total += gas[start] - cost[start];
                start--;
            } else {
                total += gas[end] - cost[end];
                end++;
            }
        }

        return total >= 0? start : -1;
    }
}
