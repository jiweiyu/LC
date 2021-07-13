package leetcode;

import java.util.HashMap;

public class WordPattern_290 {
    public boolean wordPattern(String pattern, String str) {
        String[] list = str.split(" ");
        if(pattern.length()!=list.length)return false;
        HashMap<Character, String> map = new HashMap<>();
        for(int i = 0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(list[i])) return false;
            }else if(map.containsValue(list[i])){
                return false;
            }else{
                map.put(pattern.charAt(i), list[i]);
            }
        }
        return true;
    }
}
