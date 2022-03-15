/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private void printSolution(char[][] board) {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void solve(char[][] board) {
        if (solveProblem(0, 0, board)) {
            printSolution(board);
        } else {
            System.out.println("No Soln");
        }
    }

    private boolean solveProblem(int rowIndex, int colIndex, char[][] board) {
        if (rowIndex == Constants.BOARD_SIZE) {
            colIndex++;
            if (colIndex == Constants.BOARD_SIZE)
                return true;
            else
                rowIndex = 0;
        }
        if (board[rowIndex][colIndex] != '.')
            return solveProblem(rowIndex + 1, colIndex, board);

        for (int num = Constants.MIN_VALUE; num <= Constants.MAX_VALUE; num++) {
            if (isValid(rowIndex, colIndex, num, board)) {
                board[rowIndex][colIndex] = (char) (num + 48);
                if (solveProblem(rowIndex + 1, colIndex, board))
                    return true;
                board[rowIndex][colIndex] = '.';
            }
        }
        return false;
    }

    private boolean isValid(int rowIndex, int colIndex, int num, char[][] board) {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            if (board[rowIndex][i] == (char) num)
                return false;
            if (board[i][colIndex] == (char) num)
                return false;
        }

        int boxRowOffSet = (rowIndex / 3) * Constants.BOX_SIZE;
        int boxColOffSet = (rowIndex / 3) * Constants.BOX_SIZE;
        for (int i = 0; i < Constants.BOX_SIZE; i++) {
            for (int j = 0; j < Constants.BOX_SIZE; j++) {
                if (board[boxRowOffSet + i][boxColOffSet + j] == (char)num)
                    return false;
            }
        }
        return true;
    }
}

class Constants {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    public static final int BOARD_SIZE = 9;
    public static final int BOX_SIZE = 3;

    private Constants() {

    }
}
// @lc code=end
