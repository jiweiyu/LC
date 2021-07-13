package leetcode;

public class DesignTicTacToe_348 {

    private final int[] rows;
    private final int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public DesignTicTacToe_348(int n){
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player){
        int toAdd = player==1?1:-1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if(row==col){
            diagonal += toAdd;
        }

        if(col==(cols.length - row - 1)){
            antiDiagonal += toAdd;
        }

        int size = rows.length;
        if(Math.abs(rows[row])==size
                || Math.abs(cols[col])==size
                || Math.abs(diagonal)==size
                || Math.abs(antiDiagonal)==size){
            return player;
        }
        return 0;
    }
}
