class Solution {
    public int[] twoSum(int[] arr, int k) {
        int i = 0;
        int j = arr.length - 1;
        int[] res = new int[2];

        while(i<j) {
            int temp = arr[i] + arr[j];
            if(temp == k) {
                res[0] = i+1;
                res[1] = j+1;
            }
            if(temp > k) {
                j--;
            } else {
                i++;
            }
        }

        return res;
    }
}
