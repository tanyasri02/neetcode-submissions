class Solution {
    public boolean isSafe(char[][] board, int row, int col){
        int n = board.length;
        // up
        for(int j=0;j<col;j++){
            if(board[row][j] == 'Q')
                return false;
        }

        // upper diagonal

        for(int i=row,j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q')
                return false;
        }

        // lower diagonal
        for(int i=row,j=col; i < n && j>=0; i++,j--){
            if(board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    public void helper(char[][] board, int col, int n, 
    List<List<String>> ans){
        if(col == n){
            ans.add(constructBoard(board));
            return;
        }

        for(int row=0;row<n;row++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                helper(board, col+1, n, ans);
                board[row][col] = '.';
            }
        }
    }

    List<String> constructBoard(char[][] board){
        List<String> curr = new ArrayList<>();

        for(int i=0;i<board.length;i++){
            curr.add(new String(board[i]));
        }

        return curr;
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();

        helper(board, 0, n, ans);

        return ans;
    }
}
