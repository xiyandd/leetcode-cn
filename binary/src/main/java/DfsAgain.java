class Solution {

    public void solve(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O')
                dfs(row, 0, board);
            if (board[row][columns - 1] == 'O')
                dfs(row, columns - 1, board);
        }
        for (int column = 0; column < columns; column++) {
            if (board[0][column] == 'O')
                dfs(0, column, board);
            if (board[rows - 1][column] == 'O')
                dfs(rows - 1, column, board);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j]=='O')
                    board[i][j] = 'X';
                if (board[i][j]=='A')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(int row, int column, char[][] board) {
        if (row < 0 || row > board.length-1 || column < 0 || column > board[0].length-1) {
            return;
        }
        if (board[row][column] != 'O') {
            return;
        }
        board[row][column] = 'A';
        dfs(row + 1, column, board);
        dfs(row - 1, column, board);
        dfs(row, column + 1, board);
        dfs(row, column - 1, board);

    }
}