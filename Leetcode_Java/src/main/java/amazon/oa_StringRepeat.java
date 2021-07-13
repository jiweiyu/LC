package amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

/**
 * Created by yujiwei on 18/7/14.
 */
public class oa_StringRepeat {

    public static String[] exclude_list = {"a ","am","an"};


    public static String findMostRepeat(String str){

        HashMap<String, Integer> map = new HashMap<>();

        //split with all non-alphabetic
        String replace_str = str.replaceAll("[^A-Za-z0-9]", " ");
        String[] split_str = replace_str.split(" ");

        for(int x = 0; x<split_str.length;x++){
            String a = split_str[x];
            a = a.trim();
            System.out.println("after trim: " + a);

            //to lower case
            a = a.toLowerCase();

            //check exclude_list
            if(!checkExcludeList(a)){
                //counting and store in map
                if(map.containsKey(a)){
                    map.put(a,map.get(a)+1);
                }else{
                    map.put(a,1);
                }
                System.out.println("map key: "+a+", count: "+map.get(a));
            }

        }

        Map.Entry<String, Integer> maxEntry = null;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0){
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();

    }

    private static boolean checkExcludeList(String check){
        for(int i=0;i<exclude_list.length;i++){
            if(exclude_list[i].trim().equals(check)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){

        String test = "I'am a girl am i!!!!!";
        System.out.println("Final res is: " + findMostRepeat(test));
    }
}
