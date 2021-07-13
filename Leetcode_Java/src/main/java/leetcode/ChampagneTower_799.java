package leetcode;

public class ChampagneTower_799 {

    public double champagneTower(int poured, int query_row, int query_glass){
        double[] res = new double[query_row+2];
        res[0] = poured;
        for(int row=1;row<=query_row;row++){
            for(int i=row;i>=0;i--){
                res[i+1] += res[i]=Math.max(0.0, (res[i]-1)/2);
            }
        }

        return Math.min(1.0, res[query_glass]);
    }

}
