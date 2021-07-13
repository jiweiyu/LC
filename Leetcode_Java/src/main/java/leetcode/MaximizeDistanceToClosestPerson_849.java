package leetcode;

public class MaximizeDistanceToClosestPerson_849 {

    public int maxDistToClosest(int[] seats) {
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        int res = 0;
        //if(seats[0]==0) left = 0;
        for(int i = 0;i<seats.length;i++){
            if(seats[i]==1 && left<0){
                right = i;
                left = 0;
                res = Math.max(res, right);
            }
            else if(seats[i] == 1 && left>=0){
                left = right;
                right = i;
                res = Math.max(res, (right-left)/2);
                left = i;
            }
            if(i == (seats.length-1) && seats[i]==0){
                left = right;
                res = Math.max(res, seats.length-1-left);
            }

        }
        if(left<=0){
            res = Math.max(right-0, seats.length-right-1);
        }
        return res;
    }
}
