package leetcode;

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts_1465 {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int a = getMax(h, horizontalCuts);
        int b = getMax(w, verticalCuts);
        System.out.println("check a: "+a);
        System.out.println("check b: "+b);
        return (int) (a%(1e9 + 7) * b%(1e9 + 7));
    }

    public static int getMax(int edge, int[] cuts){
        Arrays.sort(cuts);
        int ans = Math.max(cuts[0]-0, edge-cuts[cuts.length-1]);
        for(int i = 1; i<cuts.length;i++){
            ans=Math.max(ans,cuts[i]-cuts[i-1]);
        }
        return ans;
    }
}
