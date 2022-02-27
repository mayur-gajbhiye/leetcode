package com.mayur.problems.Backtracking.Sudoku;

public class Sudoku {
    private int[][] sudoku;

    public static void main(String[] args) {
        int[][] sudokuArr = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        Sudoku sudoku = new Sudoku(sudokuArr);
        sudoku.solve();
    }

    public Sudoku(int[][] sudoku) {
        this.sudoku = sudoku;
    }

    private void solve() {
        if (solveProblem(0, 0)) {
            showSolution();
        } else {
            System.out.println("No Soln");
        }
    }

    private boolean solveProblem(int rowIndex, int colIndex) {
        if (rowIndex == Constants.BOARD_SIZE) {
            colIndex++;
            if (colIndex == Constants.BOARD_SIZE)
                return true;
            else
                rowIndex=0;
        }
        if (this.sudoku[rowIndex][colIndex] != 0)
            return solveProblem(rowIndex + 1, colIndex);

        for (int num = Constants.MIN_VALUE; num <= Constants.MAX_VALUE; num++) {
            if (isValid(rowIndex, colIndex, num)) {
                this.sudoku[rowIndex][colIndex] = num;
                if (solveProblem(rowIndex + 1, colIndex))
                    return true;
                this.sudoku[rowIndex][colIndex] = 0;
            }
        }
        return false;

    }

    private boolean isValid(int rowIndex, int colIndex, int num) {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            if (this.sudoku[rowIndex][i] == num)
                return false;
        }
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            if (this.sudoku[i][colIndex] == num)
                return false;
        }

        int boxRowOffset = (rowIndex / 3) * Constants.BOX_SIZE;
        int boxColOffset = (colIndex / 3) * Constants.BOX_SIZE;

        for (int i = 0; i < Constants.BOX_SIZE; i++)
            for (int j = 0; j < Constants.BOX_SIZE; j++)
                if (this.sudoku[boxRowOffset + i][boxColOffset + j] == num)
                    return false;

        return true;
    }

    private void showSolution() {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                System.out.print(this.sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
