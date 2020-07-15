/**************************************************
 * Author: Raphael
 * Date: Wednesday July 15
 * Problem:
 * 7.22 (Knight’s Tour) An interesting puzzler for chess buffs is the Knight’s
 * Tour problem, originally proposed by the mathematician Euler. Can the knight
 * piece move around an empty chessboard and touch each of the 64 squares once and
 * only once? We study this intriguing problem in depth here. The knight makes only
 * L-shaped moves (two spaces in one direction and one space in a perpendicular direction).
 * Thus, as shown in Fig. 7.30, from a square near the middle of an empty chessboard, the knight
 * (labeled K) can make eight different moves (numbered 0 through 7).
 *
 * Row = { 2, 1, -1, -2, -2, -1, 1, 2 };
 * Column = { 1, 2, 2, 1, -1, -2, -2, -1 };
 *
 * LeftMovement is -
 * RightMovement is +
 * TopMovement is +
 * DownMovement is -
 *
 * Row[2]Column[1] - Move right 2 cells and turn once
 * Row[1]Column[2] - turn once and move twice
 * Row[-1]Column[2]
 * Row[-2]Column[1]
 * Row[-2]Column[-1]
 * Row[-1]Column[-2]
 * Row[1]Column[-2]
 * Row[2]Column[-1]
 **************************************************/


import java.text.DecimalFormat;

public class KnightTourCohortFour {
    int[][] solution;
    int path = 0;

    //TODO: Initialize solution to Zero
    public KnightTourCohortFour(int N) {
        solution = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                solution[i][j] = 0;
            }
        }
    }

    //TODO: Find possible available movement
    public void solve() {
        if (findPath(0, 0, 0, solution.length)) {
            print();
        } else {
            System.out.println("NO PATH DEPICTED");
        }
    }

    //TODO: Write the method to detect open moves
    public boolean findPath(int row, int column, int index, int N) {
        // check if current is not used already
        if (solution[row][column] != 0) {
            return false;
        }
        // mark the current cell if already used
        solution[row][column] = path++;
        // if (index == 50)
        if (index == N * N - 1) {
            // if we are here means we have solved the problem
            return true;
        }
        // try to solve the rest of the problem recursively

        // go down and right
        if (canMove(row + 2, column + 1, N)
                && findPath(row + 2, column + 1, index + 1, N)) {
            return true;
        }
        // go right and down
        if (canMove(row + 1, column + 2, N)
                && findPath(row + 1, column + 2, index + 1, N)) {
            return true;
        }
        // go right and up
        if (canMove(row - 1, column + 2, N)
                && findPath(row - 1, column + 2, index + 1, N)) {
            return true;
        }
        // go up and right
        if (canMove(row - 2, column + 1, N)
                && findPath(row - 2, column + 1, index + 1, N)) {
            return true;
        }
        // go up and left
        if (canMove(row - 2, column - 1, N)
                && findPath(row - 2, column - 1, index + 1, N)) {
            return true;
        }
        // go left and up
        if (canMove(row - 1, column - 2, N)
                && findPath(row - 1, column - 2, index + 1, N)) {
            return true;
        }
        // go left and down
        if (canMove(row + 1, column - 2, N)
                && findPath(row + 1, column - 2, index + 1, N)) {
            return true;
        }
        // go down and left
        if (canMove(row + 2, column - 1, N)
                && findPath(row + 2, column - 1, index + 1, N)) {
            return true;
        }
        // if we are here means nothing has worked , backtrack by re-initializing solution to Zero and decrementing path to reverse
        solution[row][column] = 0;
        path--;
        return false;

    }

    public boolean canMove(int row, int col, int N) {
        if (row >= 0 && col >= 0 && row < N && col < N) {
            return true;
        }
        return false;
    }

    public void print() {
        DecimalFormat two_digits = new DecimalFormat("00");
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                System.out.print("   " + two_digits.format(solution[i][j]));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 8;
        KnightTourCohortFour i = new KnightTourCohortFour(N);
        i.solve();
    }

}