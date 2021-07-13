package leetcode;
import java.util.HashMap;
public class MakingFileNamesUnique_1487 {
    public String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        HashMap<String, Integer> count = new HashMap<>();
        for(int i =0; i<names.length; i++){
            String name = names[i];
            if(!count.containsKey(name)){
                count.put(name, 1);
                res[i] = name;
            }else{
                int a = count.get(name);
                while(count.containsKey(name+"("+a+")")){
                    a++;
                }
                count.put(name, a);
                res[i] = name+"("+a+")";
                count.put(res[i], 1);
            }
        }
        return res;
    }
}
