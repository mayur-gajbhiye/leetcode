import apple.laf.JRSUIConstants.NoIndicator;

/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    private int noOfQueens;
    private int[][] chessBoard;
    private int count = 0;

    public int totalNQueens(int n) {
        this.noOfQueens = n;
        this.chessBoard = new int[noOfQueens][noOfQueens];
        for (int i = 0; i < noOfQueens; i++) {
            if(setQueen(i)){
                count++;
            }
        }
        return count;
    }

    private boolean setQueen(int colIndex) {
        if (colIndex == noOfQueens)
            return true;

        for (int rowIndex = 0; rowIndex < noOfQueens; rowIndex++) {
            if (isValid(rowIndex, colIndex)) {
                chessBoard[rowIndex][colIndex] = 1;
                if (setQueen(colIndex + 1)) {
                    return true;
                }
                chessBoard[rowIndex][colIndex] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int rowIndex, int colIndex) {
        for (int i = 0; i < colIndex; i++)
            if (chessBoard[rowIndex][i] == 1)
                return false;

        for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--)
            if (chessBoard[i][j] == 1)
                return false;

        for (int i = rowIndex, j = colIndex; i < chessBoard.length && j >= 0; i++, j--)
            if (chessBoard[i][j] == 1)
                return false;
        return true;
    }

}
// @lc code=end
