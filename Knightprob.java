import java.util.*;
import java.io.*;

class Knightprob {
    public static boolean ischeck(char[][] board, int row, int column)
    {
        //row check
        for(int i=0;i<row-1;i++)
        {
            if(board[i][column]=='Q')
            {
                return false;
            }
        }
        //diag left
        for(int i =row-1,j=column-1;i>=0 && j>=0;i--,j--)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }
        //diag right

        for(int i =row-1,j=column+1;i>=0 && j>=0 && j<board.length;i--,j++)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }
        return true;
    }
    public static void nqueens(char[][] board, int row) {
        //base case
        if (row == board.length) {
            printboard(board);
            System.out.println("New Board");
            return;
        }
        //recursion
        for (int i = 0; i < board.length; i++) {
            if(ischeck(board,row,i)==true)
            {
                board[row][i] = 'Q';
                nqueens(board, row + 1);
                board[row][i] = '-';
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
        char[][] board = new char[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = '-';
            }
        }
        nqueens(board, 0);
    }
}