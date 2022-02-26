package com.mayur.problems.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    private int noOfQueens;
    private int[][] chessBoard;

    public static void main(String[] args) {
        NQueen nQueen = new NQueen(40);
        nQueen.solve();
    }

    public NQueen(int noOfQueens) {
        this.noOfQueens = noOfQueens;
        this.chessBoard = new int[noOfQueens][noOfQueens];
    }

    private boolean setQueens(int colIndex) {
        if (colIndex == noOfQueens)
            return true;

        for (int rowIndex = 0; rowIndex < noOfQueens; rowIndex++) {
            // printBoard();
            if (isValid(rowIndex, colIndex)) {
                chessBoard[rowIndex][colIndex] = 1;
                if (setQueens(colIndex + 1)) {
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

    private void printBoard() {
        System.out.println("<============================>");
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                if (chessBoard[i][j] == 1)
                    System.out.print(" Q ");
                else
                    System.out.print(" - ");
            }
            System.out.println();
        }
    }

    private void solve() {
        if (setQueens(0))
            printBoard();
        else
            System.out.println("No Solutions found...");
    }

}
