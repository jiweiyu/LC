package leetcode;
import java.util.*;
public class SentenceSimilarityII_737 {

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length)return false;
        Map<String, String> map = getMap(pairs);

        //Uniot/Find
        for(int i =0; i<words1.length;i++){
            String w1 = words1[i];
            String w2 = words2[i];
            if(w1.equals(w2)){
                continue;
            }
            String head1 = find(w1, map);
            String head2 = find(w2, map);
            if(head1 == null || head2 == null || !head1.equals(head2)){
                return false;
            }
        }
        return true;
    }
    private HashMap<String, String> getMap(List<List<String>> pairs){
        HashMap<String, String> map = new  HashMap<String, String>();
        for(List<String> list: pairs){
            map.put(list.get(0), list.get(1));
            map.put(list.get(1), list.get(0));
        }
        return map;
    }
    private String find(String w, Map<String, String> map){
        if(!map.containsKey(w)){
            return null;
        }
        if (map.get(w).equals(w)){
            return w;
        }
        return find(map.get(w), map);
    }
    private void union(String w1, String w2, Map<String, String> map){
        String head1 = find(w1, map);
        String head2 = find(w2, map);
        if(head1 == null && head2 == null){
            map.put(w1, w1);
            map.put(w2, w2);
        }else if(head1 == null && head2 != null){
            map.put(w1, head2);
        }else if(head1 != null && head2 == null){
            map.put(w2, head1);
        }else{
            map.put(head1, head2);
        }
    }
}
