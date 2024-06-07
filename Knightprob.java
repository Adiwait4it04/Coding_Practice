import java.util.*;
import java.io.*;

class Knightprob {
    public static boolean ischeck(char[][] board, int row, int column) {
        // 1 left 2 upar
        if (row - 1 >= 0 && column - 2 >= 0) {
            if (board[row - 1][column - 2] == 'Q') {
                return false;
            }
        }
        if (row - 2 >= 0 && column - 1 >= 0) {
            if (board[row - 2][column - 1] == 'Q') {
                return false;
            }
        }
        if (row + 2 < board.length && column - 1 >= 0) {
            if (board[row + 2][column - 1] == 'Q') {
                return false;
            }
        }
        if (row + 1 < board.length && column - 2 >= 0) {
            if (board[row + 1][column - 2] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void nqueens(char[][] board, int row) {
        // base case
        if (row == board.length) {
            printboard(board);
            System.out.println("New Board");
            return;
        }
        // recursion
        for (int i = 0; i < board.length; i++) {
            if (ischeck(board, row, i)) {
                board[row][i] = 'Q';
                nqueens(board, row + 1);
            }
        }
    }

    public static void printboard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        nqueens(board, 0);
    }
}