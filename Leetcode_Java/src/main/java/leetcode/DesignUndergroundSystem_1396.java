package leetcode;

import javafx.util.Pair;

import java.util.HashMap;

public class DesignUndergroundSystem_1396 {

    //java 8, Pair<V,K> in javafx.util
    // Route - {TotalTime, Count}
    HashMap<String, Pair<Integer, Integer>> checkoutMap = new HashMap<>();
    // Uid - {StationName, Time}
    HashMap<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();

    public DesignUndergroundSystem_1396(){}

    public void checkIn(int id, String stationName, int t){
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t){
        Pair<String, Integer> checkIn = checkInMap.get(id);
        String route = checkIn.getKey() + "_" + stationName;
        int totalTime = t - checkIn.getValue();
        Pair<Integer, Integer> checkout = checkoutMap.getOrDefault(route, new Pair<>(0,0));
        checkoutMap.put(route, new Pair<>(checkout.getKey()+totalTime, checkout.getValue()+1));
    }

    public double getAverageTime(String startStation, String endStation){
        String route = startStation + "_" + endStation;
        Pair<Integer, Integer> checkout = checkoutMap.get(route);
        return (double)checkout.getKey()/checkout.getValue();
    }
}
