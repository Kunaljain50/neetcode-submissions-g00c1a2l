class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0;
        int j = n-1;

        int ans = 0;

        while(i<j) {
            int area = Math.min(heights[i], heights[j]) * (j-i);
            ans = Math.max(ans, area);

            if(heights[i] <= heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return ans;

    }
}
