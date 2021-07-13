package leetcode;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner_489 {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        backtracking(robot, visited, 0, 0, 0);
    }

    int[][] dir = {{1,0}, {0,1}, {-1,0}, {0, -1}};

    private void backtracking(Robot robot, Set<String> visited, int x, int y, int arrow) {
        String path = x + "-" + y;
        if (visited.contains(path)) return;
        visited.add(path);
        robot.clean();

        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                //go all the way till cannot move, then back one step
                int nx = x + dir[arrow][0];
                int ny = y + dir[arrow][1];

                backtracking(robot, visited, nx, ny, arrow);
                //trace back
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
            arrow = (arrow + 1) % 4;
        }
    }

}

class Robot{
    void turnLeft(){

    }
    void turnRight(){

    }
    void clean(){

    }
    boolean move(){
        return true;
    }
}