package leetcode;
import java.util.*;
public class SortCharactersByFrequency_451 {

    public String frequencySort(String s) {
        HashMap<Character,Integer> count = new HashMap<>();
        TreeMap<Integer,List<Character>> map = new TreeMap<>();
        for(Character a : s.toCharArray()){
            count.put(a, count.getOrDefault(a,0)+1);
        }
        //System.out.println(count.size());
        for(Map.Entry<Character,Integer> entry : count.entrySet()){
            //System.out.println(entry.getValue()+","+entry.getKey());
            List<Character> l = map.getOrDefault(entry.getValue(), new LinkedList<Character>());
            l.add(entry.getKey());
            map.put(entry.getValue(), l);
        }
        //System.out.println(map.size());
        StringBuilder sb = new StringBuilder();
        for(int a : map.descendingKeySet()){
            List<Character> list = map.get(a);
            for(Character x : list){
                //System.out.println("check:"+x);
                for(int i=0;i<a;i++){
                    sb.append(x);
                }
            }
        }
        return sb.toString();
    }
}
