package leetcode;

import java.util.Arrays;

public class RandomPickWithWeight_528 {


    //Binary search
    private int[] prob;
    private int t;

    public RandomPickWithWeight_528(int[] w) {
        prob = new int[w.length];

        int cur = 0;
        for(int i=0;i<w.length;i++){
            cur += w[i];
            prob[i] = cur;
        }
        t = cur;
    }

    public int pickIndex_() {
        double target = this.t * Math.random();
        int l = 0, r = this.prob.length;
        while(l < r){
            int m = l + (r - l) / 2;
            if(target > prob[m]) l = m + 1;
            else r = m;
        }
        return l;
    }


//    private final double[] probabilities;

    //O(N)
//    public RandomPickWithWeight_528(int[] w) {
//        double sum = 0;
//        this.probabilities = new double[w.length];
//        for(int weight : w)
//            sum += weight;
//        for(int i = 0; i < w.length; i++){
//            w[i] += (i == 0) ? 0 : w[i - 1];
//            probabilities[i] = w[i]/sum;
//        }
//    }

    //O(1)
//    public int pickIndex() {
//        return Math.abs(Arrays.binarySearch(this.probabilities, Math.random())) - 1;
//    }
}
