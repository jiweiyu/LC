package leetcode;

import java.util.LinkedList;

/*
If time O(1) is required for getValue(), method 1 is a better option;
If time O(1) is required for updateSubrectangle(), method 2 is a better option;
Generally speaking, if the the size of update history is greater than the updated data volume, method 1 is better; otherwise, method 2 is better.
 */

public class SubrectangleQueries_1476 {

/////1
    private final int[][] r;

    public SubrectangleQueries_1476(int[][] rectangle) {
        r = rectangle;
    }

    public void updateSubrectangle_1(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; ++i) {
            for (int j = col1; j <= col2; ++j) {
                r[i][j] = newValue;
            }
        }
    }

    public int getValue_1(int row, int col) {
        return r[row][col];
    }

/////2
    private final LinkedList<int[]> histories = new LinkedList<>();


    public void updateSubrectangle_2(int row1, int col1, int row2, int col2, int newValue) {
        histories.push(new int[]{row1, col1, row2, col2, newValue});
    }

    public int getValue_2(int row, int col) {
        for (int[] his: histories) {
            if (his[0] <= row && row <= his[2] && his[1] <= col && col <= his[3]) {
                return his[4];
            }
        }
        return r[row][col];
    }
}
