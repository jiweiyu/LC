package bloomberg;

import java.util.*;
/**
 * Created by yujiwei on 18/7/9.
 */
public class killProcess_582 {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for(int i=0;i<pid.size();i++){
            int child = pid.get(i);
            int parent = ppid.get(i);

            if(parent != 0){
                if(!tree.containsKey(parent)){
                    tree.put(parent, new ArrayList<Integer>());
                }
                tree.get(parent).add(child);
            }
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            if(tree.containsKey(node)){
                for(int child:tree.get(node)){
                    queue.offer(child);
                }
            }
        }
        return res;
    }
}
