package GRAPH.RaghavGarg;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    public static class Pair{
        int row, col;
        Pair(int i, int j){
            this.row = i;
            this.col = j;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    bfs(i, j, grid, vis);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] vis) {
        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));

        while(!q.isEmpty()){
            Pair front = q.remove();
            int row = front.row, col = front.col;

            // no need to check left and top
            // just check right and down
            // top -> row -1 , col
            if(row > 0){
                if(!vis[row - 1][col] && grid[row - 1][col] == '1'){
                    q.add(new Pair(row - 1, col));
                    vis[row -1][col] = true;
                }
            }

            //bottom -> row + 1
            if(row + 1 < m){
                if(!vis[row + 1][col] && grid[row + 1][col] == '1'){
                    q.add(new Pair(row + 1, col));
                    vis[row +1][col] = true;
                }
            }

            // left -> col - 1
            if(col > 0){
                if(!vis[row][col - 1] && grid[row][col - 1] == '1'){
                    q.add(new Pair(row, col - 1));
                    vis[row][col - 1] = true;
                }
            }
            // right -> row - 1
            // left -> col - 1
            if(col + 1< n){
                if(!vis[row][col + 1] && grid[row][col + 1] == '1'){
                    q.add(new Pair(row, col + 1));
                    vis[row][col + 1] = true;
                }
            }
        }
    }
}
