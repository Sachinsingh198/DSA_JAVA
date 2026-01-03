package BackTracking;

public class RatInDeadMazeOptimized {
    private static void print(int sr, int sc, int er, int ec, String s, int[][] maze){
        if(sr < 0 || sc < 0 || sr > er || sc > ec) return;
        if(maze[sr][sc] == 0 || maze[sr][sc] == -1) return;

        if(sr == er && sc == ec) {
            System.out.println(s);
            return;
        }

      maze[sr][sc] = -1;

        // explore all 4 directions
        print(sr, sc + 1, er, ec, s + "R", maze);
        print(sr + 1, sc, er, ec, s + "D", maze);
        print(sr, sc - 1, er, ec, s + "L", maze);
        print(sr - 1, sc, er, ec, s + "U", maze);

        maze[sr][sc] = 1;

    }

    public static void main(String[] args) {
        int rows = 4;
        int cols = 6;
        int[][] maze = {
                {1,1,1,1,0,1},
                {1,1,0,1,0,1},
                {1,0,1,1,1,1},
                {1,1,1,0,1,1}
        };
        print(0, 0, rows - 1, cols - 1, "", maze);
    }
}
