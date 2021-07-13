package leetcode;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern_1152 {

    class Pair{
        int time;
        String web;
        Pair(int t, String w){
            this.time = t;
            this.web = w;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, List<Pair>> map = new HashMap<>();
        for(int i=0;i<username.length;i++){
            String u = username[i];
            int t = timestamp[i];
            String w = website[i];
            map.putIfAbsent(u, new ArrayList<Pair>());
            map.get(u).add(new Pair(t,w));
        }

        Map<String,Integer> count = new HashMap<>();

        String res = "";
        for(String key: map.keySet()){
            Set<String> set = new HashSet<>();
            List<Pair> list = map.get(key);
            Collections.sort(list,(a,b)->(a.time-b.time));

            for(int i=0;i<list.size();i++){
                for(int j=i+1;j<list.size();j++){
                    for(int k=j+1;k<list.size();k++){
                        String str = list.get(i).web+" "+list.get(j).web+" "+list.get(k).web;
                        if(!set.contains(str)){
                            set.add(str);
                            count.put(str,count.getOrDefault(str,0)+1);
                        }
                        if(res=="" ||
                                count.get(res)<count.get(str) ||
                                count.get(res)==count.get(str) && res.compareTo(str) > 0){
                            res=str;
                        }
                    }
                }
            }
        }
        String[] r = res.split(" ");
        List<String> result = new ArrayList<String>();
        for(String a : r){
            result.add(a);
        }
        return result;
    }
}
