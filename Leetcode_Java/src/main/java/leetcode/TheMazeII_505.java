package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheMazeII_505 {
    int[][] steps = new int[][]{{-1,0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] distance = new int[m][n];  //can also use a hashmap
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[2] - p2[2]);
        distance[start[0]][start[1]] = 0;
        pq.add(new int[]{start[0], start[1], 0});

        while (!pq.isEmpty()) {
            int[] pos = pq.poll();
            //visit.. Optional but help decrease runtime...
            if (maze[pos[0]][pos[1]] == 2) { continue; }  //this is here because we might have inserted the same node twice in the PQ.
            maze[pos[0]][pos[1]] = 2;

            if (pos[0] == destination[0] && pos[1] == destination[1]) {
                return distance[pos[0]][pos[1]]; //this is now the shortest distance in the pq.
                //thus, this IS the shortest distance from the source to the destination.
            }
            for (int i=0; i<4; i++) {
                int[] newPos = move(i, pos[0], pos[1], maze);
                int totalDistance = distance[pos[0]][pos[1]] + newPos[2];
                if (totalDistance < distance[newPos[0]][newPos[1]] &&
                        maze[newPos[0]][newPos[1]] != 2) {  //not visited.. dont need to add visited node into queue anymore, since we already foudn their shortest distance
                    distance[newPos[0]][newPos[1]]  =  totalDistance;
                    newPos[2] = totalDistance;
                    pq.add(newPos);
                }
            }
        }
        return -1;
    }

    private int[] move(int dir, int x, int y, int[][] maze){
        int[] pos = new int[]{x, y, 0};
        while(isValid(maze, pos[0]+steps[dir][0] , pos[1] +  steps[dir][1])) {
            pos[0] += steps[dir][0];
            pos[1] += steps[dir][1];
            pos[2] += 1;
        }
        return pos;
    }

    public boolean isValid(int[][] maze, int x, int y) {
        if (!(x>=0 && y >=0 && x < maze.length && y < maze[0].length)) { return false; }
        return maze[x][y] != 1; //not a wall
    }
}
