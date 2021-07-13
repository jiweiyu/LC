package leetcode;

public class TheMaze_490 {
    int[][] directions = {{0,1}, {0, -1}, {1, 0}, {-1,0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination){
        if(maze.length == 0 || maze[0].length == 0) return false;
        return dfs(maze, start, destination, new boolean[maze.length][maze[0].length]);
    }

    private boolean dfs(int[][] maze,
                        int[] current,
                        int[] destination,
                        boolean[][] visited
    ){
        if(current[0] == destination[0] && current[1] == destination[1]) return true;
        int x = current[0], y = current[1];
        if(x < 0 || y < 0 || x > maze.length || y > maze[0].length || visited[x][y]) return false;
        visited[x][y] = true;
        for(int i = 0; i < directions.length;i++){
            int xx = x, yy = y;
            while(xx >= 0 &&
                  xx < maze.length &&
                  yy >= 0 &&
                  yy <= maze[0].length &&
                  maze[xx][yy] == 0){
                xx += directions[i][0];
                yy += directions[i][1];
            }
            if(dfs(maze, new int[]{xx-directions[i][0], yy-directions[i][1]}, destination, visited)){
                return true;
            }
        }
        return false;
    }
}
