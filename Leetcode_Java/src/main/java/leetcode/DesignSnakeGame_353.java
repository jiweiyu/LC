package leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DesignSnakeGame_353 {

    Set<Integer> set;
    Deque<Integer> body;
    int score;
    int[][] food;
    int foodIndex;
    int width;
    int height;

    public DesignSnakeGame_353(int width, int height, int[][] food){
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        set.add(0);
        body = new LinkedList<>();
        body.offerLast(0);
    }

    public int move(String direction){
        if(score==-1){
            return -1;
        }

        int rowHead = body.peekFirst()/width;
        int colHead = body.peekFirst()%width;
        switch(direction){
            case "U" : rowHead--;
                       break;
            case "D" : rowHead++;
                       break;
            case "L" : colHead--;
                       break;
            case "R" : colHead++;
                       break;
        }

        int head = rowHead * width + colHead;

        set.remove(body.peekLast());
        if(rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)){
            return score=-1;
        }

        set.add(head);
        body.offerFirst(head);

        if(foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]){
            set.add(body.peekLast());
            foodIndex++;
            return ++score;
        }

        body.pollLast();
        return score;
    }

}
