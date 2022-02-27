package com.mayur.problems.Backtracking;

public class KnightMoves {
    private int boardSize;
    private int[][] chessBoard;
    private int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void main(String[] args) {
        KnightMoves knightMoves=new KnightMoves(5);
        knightMoves.solve();
    }

    public KnightMoves(int boardSize) {
        this.boardSize = boardSize;
        this.chessBoard = new int[boardSize][boardSize];
        this.init();
    }

    private void solve() {
        this.chessBoard[(boardSize/2)][(boardSize/2)] = 0;
        if (solveProblem(1, 0, 0)) {
            printSolution();
        } else {
            System.out.println("No Soln");
        }
    }

    private void printSolution() {
        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                System.out.print(this.chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean solveProblem(int stepCount, int x, int y) {
        if (stepCount == boardSize * boardSize)
            return true;

        for (int i = 0; i < xMoves.length; i++) {
            int nextX = x + xMoves[i];
            int nextY = y + yMoves[i];
            if (isValid(nextX, nextY)) {
                this.chessBoard[nextX][nextY] = stepCount;
                if (solveProblem(stepCount + 1, nextX, nextY))
                    return true;
                this.chessBoard[nextX][nextY] = Integer.MIN_VALUE;
            }
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        if (x < 0 || x >= boardSize)
            return false;
        if (y < 0 || y >= boardSize)
            return false;

        if (this.chessBoard[x][y] != Integer.MIN_VALUE)
            return false;
        return true;
    }

    public void init() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.chessBoard[i][j] = Integer.MIN_VALUE;
            }
        }
    }

}
