class Solution {

    public void dfs(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 'O')
            return;

        grid[i][j] = 'S';

        dfs(grid, i + 1, j, n, m);
        dfs(grid, i - 1, j, n, m);
        dfs(grid, i, j + 1, n, m);
        dfs(grid, i, j - 1, n, m);
    }

    public void solve(char[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            dfs(board, i, 0, n, m);
            dfs(board, i, m - 1, n, m);
        }

        for (int j = 0; j < m; j++) {
            dfs(board, 0, j, n, m);
            dfs(board, n - 1, j, n, m);
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'S')
                    board[i][j] = 'O';
            }
        }
    }
}
