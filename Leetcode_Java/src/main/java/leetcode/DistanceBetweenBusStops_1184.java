package leetcode;

public class DistanceBetweenBusStops_1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for(int a : distance) sum+=a;

        int small = start<destination ? start: destination;
        int big = small == start? destination : start;
        int tmp = 0;
        for(int i=small;i<big;i++){
            tmp += distance[i];
        }

        return Math.min(tmp, sum-tmp);
    }
}
