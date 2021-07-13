package leetcode;

public class MinimumCostToMoveChipsToTheSamePosition_1217 {

    public int minCostToMoveChips(int[] A){
        int odd = 0, even = 0;
        for(int a : A){
            if(a%2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        return Math.min(odd,even);
    }

}
