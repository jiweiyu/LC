package leetcode;
import java.util.*;
public class DestinationCity_1436 {
    public String destCity(List<List<String>> paths) {
        HashSet<String> cities = new HashSet<String>();
        for(List<String> to : paths){
            cities.add(to.get(1));
        }
        for(List<String> from : paths){
            cities.remove(from.get(0));
        }

        return cities.iterator().next();
    }
}
