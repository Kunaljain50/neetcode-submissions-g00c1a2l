class Solution {
    int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, 1, 0, -1};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOrangesCnt = 0;
        int multiple = -1;

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    multiple++;
                } else if (grid[i][j] == 1) {
                    freshOrangesCnt++;
                }
            }
        }

        if(freshOrangesCnt == 0) return 0;
        int minutes = 0;

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            boolean flag = false;

            for(int i = 0; i< 4; i++) {
                int row = arr[0] + delRow[i];
                int col = arr[1] + delCol[i];

                if(isValid(row, col, m, n)
                && grid[row][col] == 1) {
                    grid[row][col] = 2;
                    queue.add(new int[]{row, col});
                    freshOrangesCnt--;
                    flag = true;
                }
            }

            if(flag) {
                minutes++;
            }
        }

        if(multiple > 0) {
            return minutes - multiple;
        }

        return freshOrangesCnt == 0 ? minutes : -1;
    }

    public static boolean isValid(int i, int j, int m, int n) {
        if(i<0 || i>=m) return false;
        if(j<0 || j>=n) return false;
        return true;
    }
}
