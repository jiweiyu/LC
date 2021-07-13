package facebook;
import java.util.*;
public class RevenueMilestones {

    int[] getMilestoneDays(int[] revenues, int[] milestones) {
        // Write your code here
        int[] res = new int[milestones.length];
        int sum = 0;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i = 0;i<revenues.length;i++){
            sum += revenues[i];
            tm.put(sum, i+1);
        }

        for(int i=0;i<milestones.length;i++){
            if(tm.containsKey(milestones[i])){
                res[i] = tm.get(milestones[i]);
            }else{
                res[i] = tm.higherEntry(milestones[i]).getValue();
            }

        }

        return res;
    }

}
