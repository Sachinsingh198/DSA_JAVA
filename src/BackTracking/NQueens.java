package BackTracking;

import java.util.Scanner;

public class NQueens {
    private static void nqueen(char[][] board, int row){
        int n = board.length;
        if(row == n){
            for(char[] r : board){
                for(char el : r){
                    System.out.print(el + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int j = 0; j < n; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nqueen(board, row+1);
                board[row][j] = '.';//backtracking
            }
        }

        return;
    }

    private static boolean isSafe(char[][] board, int row, int col){
        for(int j = 0; j < board.length; j++){
            if(board[row][j] == 'Q') return false;
        }
        for(int i = 0;  i < board.length; i++){
            if(board[i][col] == 'Q') return false;
        }
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }
        for(int i = row, j = col; i < board.length && j < board.length;i++,j++){
            if(board[i][j] == 'Q') return false;
        }
        for(int i = row, j = col; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q') return false;
        }
        for(int i = row, j = col;i < board.length && j >= 0; i++, j-- ){
            if(board[i][j] == 'Q') return false;
        }
        for(int i = row, j = col; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print ("Enter n: ");
        int n = scr.nextInt();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        nqueen(board, 0);
    }
}
