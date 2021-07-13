package leetcode;

public class TeemoAttacking_495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries==null || timeSeries.length==0) return 0;

        int curStart = timeSeries[0], curEnd = timeSeries[0]+duration-1;
        int prevEnd = curEnd;
        int total = duration;

        for(int i=1;i<timeSeries.length;i++){
            int time = timeSeries[i];
            curStart=time;
            curEnd=time+duration-1;
            if(curStart>prevEnd) total+=duration;
            else total+= duration-(prevEnd-curStart+1);
            prevEnd = curEnd;
        }
        return total;
    }

}
