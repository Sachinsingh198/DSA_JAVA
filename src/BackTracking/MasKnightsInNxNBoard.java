package BackTracking;

public class MasKnightsInNxNBoard {
    static int maxKnights = -1;
    static int total = 0;
    static int printTotal = 5;
    private static boolean isSafe(char[][] board,int row, int col ){
        int n = board.length;
        int i, j;
        // 2 up 1 right;
        i = row - 2;
        j = col + 1;
        if(i >=0 && j < n && board[i][j] == 'K') return false;

        // 2 up 1 left
        i = row - 2;
        j = col - 1;
        if(i >= 0 && j >= 0 && board[i][j] == 'K') return false;

        // 2 down 1 right
        i = row + 2;
        j = col + 1;
        if(i < n && j < n && board[i][j] == 'K') return false;

        // 2 down i left
        i = row + 2;
        j = col - 1;
        if(i < n && j >= 0 && board[i][j] == 'K')return  false;

        // 2 right 1 up
        i = row - 1;
        j = col + 2;
        if(i >= 0 && j < n && board[i][j] == 'K') return false;

        // 2 right 1 down
        i = row + 1;
        j = col + 2;
        if(i < n && j < n && board[i][j] == 'K')return false;

        // 2 left 1 up
        i = row - 1;
        j = col - 2;
        if(i >= 0 && j >= 0 && board[i][j] == 'K') return false;

        // 2 left 1 down
        i = row + 1;
        j = col - 2;
        if(i < n && j >= 0 && board[i][j] == 'K')return false;

        return true;
    }

    public static void nKnight(char[][] board, int row, int col, int number){
        int n = board.length;
        if(row == n){
            total += 1;
            maxKnights = Math.max(maxKnights, number);
//            if(number == printTotal){
//                for(char[] arr : board){
//                    for(char el : arr){
//                        System.out.print(el);
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//            }

            return;
        }
        else if(isSafe(board, row, col)){
            board[row][col] = 'K';
            if(col != n - 1) nKnight(board, row, col + 1, number + 1);
            else nKnight(board, row + 1, 0, number + 1);
            board[row][col] = 'x';// backtracking
        }

        if(col != n - 1) nKnight(board, row, col + 1, number );
        else nKnight(board, row + 1, 0, number);


    }

    public static void main(String[] args) {
        int n = 3;
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j= 0; j < n; j++){
                board[i][j] = 'x';
            }
        }

        nKnight(board, 0, 0, 0);
        System.out.println(maxKnights);
    }
}
