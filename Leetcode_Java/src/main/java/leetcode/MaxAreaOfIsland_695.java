package leetcode;

public class MaxAreaOfIsland_695 {

    int max = 0, cur = 0;

    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid.length == 0) return 0;
        int r = grid.length;
        int c = grid[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    cur = 0;
                    help(grid, i, j);
                    max = Math.max(max,cur);
                }
            }
        }
        return max;
    }

    private void help(int[][] grid, int i, int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length) return;
        if(grid[i][j]==0) return;
        cur++;
        grid[i][j]=0;
        help(grid,i+1,j);
        help(grid,i,j+1);
        help(grid,i-1,j);
        help(grid,i,j-1);
    }
}
