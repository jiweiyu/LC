package leetcode;
import java.util.*;
public class MinimumKnightMoves_1197 {

    int[][] dir = new int[][]{{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{0,0});
        int res = 0;
        HashSet<String> visited = new HashSet<>();
        visited.add("0,0");
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                if(cur[0]==x && cur[1]==y){
                    return res;
                }

                for(int[] d : dir){
                    int newX = cur[0]+d[0], newY = cur[1]+d[1];
                    if(newX>=-1 &&  newY>=-1 && !visited.contains(newX+","+newY)){
                        q.add(new int[]{newX, newY});
                        visited.add(newX+","+newY);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
