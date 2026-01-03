package BackTracking;

public class RatInADeadMaze {
    private static void print(int sr, int sc, int er, int ec, String s, int[][] maze, boolean[][] visited){
        if(sr < 0 || sc < 0 || sr > er || sc > ec) return;
        if(maze[sr][sc] == 0 || visited[sr][sc]) return;

        if(sr == er && sc == ec) {
            System.out.println(s);
            return;
        }

        visited[sr][sc] = true;

        // explore all 4 directions
        print(sr, sc + 1, er, ec, s + "R", maze, visited);
        print(sr + 1, sc, er, ec, s + "D", maze, visited);
        print(sr, sc - 1, er, ec, s + "L", maze, visited);
        print(sr - 1, sc, er, ec, s + "U", maze, visited);

        visited[sr][sc] = false; // backtrack
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
        print(0, 0, rows - 1, cols - 1, "", maze, new boolean[rows][cols]);
    }
}
