class Solution {
    static int[] delRow = {-1, 0, 1, 0};
    static int[] delCol = {0, 1, 0, -1};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        if(n == 1 || m == 1) return;

        int[][] vis = new int[m][n];

        // top row
        for(int i = 0; i<n; i++) {
            if(board[0][i] == 'O' && vis[0][i] == 0) {
                dfs(board, vis, 0, i, m, n);
            }
        }

        // left col
        for(int i = 0; i<m; i++) {
            if(board[i][0] == 'O' && vis[i][0] == 0) {
                dfs(board, vis, i, 0, m, n);
            }
        }

        // bootom row
        for(int i = 0; i<n; i++) {
            if(board[n-1][i] == 'O' && vis[n-1][i] == 0) {
                dfs(board, vis, n-1, i, m, n);
            }
        }

        // right most col
        for(int i = 0; i<m; i++) {
            if(board[i][m-1] == 'O' && vis[i][m-1] == 0) {
                dfs(board, vis, i, m-1, m, n);
            }
        }

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                char matChar = board[i][j];
                if (matChar == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void dfs(char[][] board, int[][] vis, int row, int col, int m, int n) {
        vis[row][col] = 1;

        for(int i = 0; i<4; i++) {
            int newRow = row + delRow[i];
            int newCol = row + delCol[i];

            if(isValid(newRow, newCol, m, n)
            && board[newRow][newCol] == 'O'
            && vis[newRow][newCol] == 0
            ) {
                dfs(board, vis, newRow, newCol, m, n);
            }
        }
    }

    public static boolean isValid(int i, int j, int m, int n) {
        if(i<0 || i>=m) return false;
        if(j<0 || j>=n) return false;
        return true;
    }
}
