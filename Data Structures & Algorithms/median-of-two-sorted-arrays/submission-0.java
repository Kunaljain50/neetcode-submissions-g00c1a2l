class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
    int m = arr2.length;

    int[] arr = new int[n + m];

    int count = 0;
    int x = 0;
    int y = 0;

    while (x < n && y < m) {
      if (arr1[x] > arr2[y]) {
        arr[count++] = arr2[y++];
      } else {
        arr[count++] = arr1[x++];
      }
    }

    while (x < n) {
      arr[count++] = arr1[x++];
    }

    while (y < m) {
      arr[count++] = arr2[y++];
    }

    int k = n + m;

    if (k % 2 == 1) {
      return (double) arr[k / 2];
    }
    return ((double) arr[k / 2] + (double) arr[k / 2 - 1]) / 2.0;
    }
}
