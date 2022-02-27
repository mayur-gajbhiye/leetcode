package com.mayur.problems.Backtracking;

public class MazeProblem {
    private int mazeSize;
    private int[][] maze;
    private int[][] solution;

    public static void main(String[] args) {
        int[][] maze=new int[][]{{1,1,1,1}, 
                                 {1,1,0,0},
                                 {0,1,0,1},
                                 {1,1,1,1}};
        MazeProblem mazeProblem=new MazeProblem(maze);
        mazeProblem.solve();  
    }

    public MazeProblem(int[][] maze) {
        this.maze=maze;
        this.mazeSize = maze.length;
        this.solution = new int[mazeSize][mazeSize];
    }

    private void solve() {
        if (solveProblem(0, 0)) {
            printSolution();
        } else {
            System.out.println("no soln");
        }
    }

    private boolean solveProblem(int x, int y) {
        if (isFinished(x, y))
            return true;

        if (isValid(x, y)) {
            solution[x][y] = 1;
            if (solveProblem(x, y + 1))
                return true;
            if (solveProblem(x + 1, y))
                return true;
            solution[x][y] = 0;
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        if (x < 0 || x >= mazeSize || y < 0 || y >= mazeSize)
            return false;
        if (this.maze[x][y] != 1)
            return false;
        return true;
    }

    private boolean isFinished(int x, int y) {
        if (x == mazeSize - 1 && y == mazeSize - 1) {
            this.solution[x][y] = 1;
            return true;
        }
        return false;
    }

    private void printSolution() {
        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                System.out.print(this.solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}
