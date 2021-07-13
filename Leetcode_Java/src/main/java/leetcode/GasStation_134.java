package leetcode;

public class GasStation_134 {

    //If car starts at A and can not reach B. Any station between A and B
    //can not reach B.(B is the first station that A can not reach.)
    //If the total number of gas is bigger than the total number of cost. There must be a solution.
    public int canCompleteCircuit(int[] gas, int[] cost){
        int tank = 0;
        for(int i=0;i<gas.length;i++){
            tank+=gas[i]-cost[i];
        }
        if(tank<0) return -1;

        int start = 0;
        int accumulate = 0;
        for(int i=0;i<gas.length;i++){
            int curGain = gas[i]-cost[i];
            if(accumulate + curGain <0){
                start = i+1;
                accumulate = 0;
            }
            else accumulate += curGain;
        }
        return start;
    }
}
