class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for(char it : tasks) {
            count[it - 'A']++;
        }

        int maxf = Arrays.stream(count).max().getAsInt();
        int maxCnt = 0;

        for(int i : count) {
            if (i == maxf) {
                maxCnt++;
            }
        }

        int time = (maxf-1) * (n+1) + maxCnt;

        return Math.max(time, tasks.length);
    }
}
