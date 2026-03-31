class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] leftMaxArr = getLeftMaxArr(arr, n);
        int[] rightMaxArr = getRightMaxArr(arr, n);

        int total = 0;
        for(int i = 0; i<n; i++) {
            total += Math.min(leftMaxArr[i], rightMaxArr[i]) - arr[i];
        }

        return total;
    }

    public static int[] getLeftMaxArr(int[] arr, int n) {
        int[] ans = new int[n];
        ans[0] = arr[0];

        for(int i = 1; i<n; i++) {
            ans[i] = Math.max(ans[i-1], arr[i]);
        }

        return ans;
    }

    public static int[] getRightMaxArr(int[] arr, int n) {
        int[] ans = new int[n];
        ans[n-1] = arr[n-1];

        for(int i = n-2; i>=0; i--) {
            ans[i] = Math.max(ans[i+1], arr[i]);
        }

        return ans;
    }
}
