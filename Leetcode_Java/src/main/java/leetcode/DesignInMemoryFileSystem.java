package leetcode;
/*
https://leetcode.com/articles/design-in-memory-file-system/
 */
import java.util.*;
public class DesignInMemoryFileSystem {

    class Dir{
        HashMap<String, Dir> dirs = new HashMap<>();
        HashMap<String, String> files = new HashMap<>();
    }

    Dir root;
    public DesignInMemoryFileSystem(){
        root = new Dir();
    }

//    The time complexity of executing an ls command is O\big(m+n+klog(k)\big)O(m+n+klog(k)). Here, mm refers to the length of the input string. We need to scan the input string once to split it and determine the various levels. nn refers to the depth of the last directory level in the given input for ls. This factor is taken because we need to enter nn levels of the tree structure to reach the last level. kk refers to the number of entries(files+subdirectories) in the last level directory(in the current input). We need to sort these names giving a factor of klog(k)klog(k).
    public List<String> ls(String path){
        Dir t = root;
        List<String> files = new ArrayList<>();
        if(!path.equals("/")){
            String[] d = path.split("/");
            for(int i = 1; i < d.length-1; i++){
                t=t.dirs.get(d[i]);
            }
            if(t.files.containsKey(d[d.length-1])){
                files.add(d[d.length-1]);
                return files;
            }else {
                t = t.dirs.get(d[d.length - 1]);
            }
        }
        files.addAll(new ArrayList<>(t.dirs.keySet()));
        files.addAll(new ArrayList<>(t.files.keySet()));
        Collections.sort(files);
        return files;
    }
//   The time complexity of executing an mkdir command is O(m+n)O(m+n). Here, mm refers to the length of the input string. We need to scan the input string once to split it and determine the various levels. nn refers to the depth of the last directory level in the mkdir input. This factor is taken because we need to enter nn levels of the tree structure to reach the last level.
    public void mkdir(String path){
        Dir t = root;
        String[] d = path.split("/");
        for(int i = 1; i < d.length; i++){
            if(!t.dirs.containsKey(d[i])){
                t.dirs.put(d[i], new Dir());
            }
            t = t.dirs.get(d[i]);
        }
    }
//The time complexity of both addContentToFile and readContentFromFile is O(m+n)O(m+n). Here, mm refers to the length of the input string. We need to scan the input string once to split it and determine the various levels. nn refers to the depth of the file name in the current input. This factor is taken because we need to enter nn levels of the tree structure to reach the level where the files's contents need to be added/read from.
    public void addContentToFile(String filePath, String content){
        Dir t = root;
        String[] d = filePath.split("/");
        for(int i = 1; i < d.length-1; i++){
            t = t.dirs.get(d[i]);
        }
        t.files.put(d[d.length-1], t.files.getOrDefault(d[d.length-1], "") + content);
    }

    public String readContentFromFile(String filePath){
        Dir t = root;
        String[] d = filePath.split("/");
        for(int i = 1; i< d.length -1 ; i++){
            t= t.dirs.get(d[i]);
        }
        return t.files.get(d[d.length-1]);
    }

}
