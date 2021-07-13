package leetcode;
import java.util.*;
public class EmployeeImportance_690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Integer> map_ip = new HashMap<>();
        HashMap<Integer,List<Integer>> map_so = new HashMap<>();
        for(Employee e : employees){
            map_ip.put(e.id, e.importance);
            map_so.put(e.id, e.subordinates);
        }

        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int i = q.poll();
            List<Integer> list = map_so.get(i);
            res += map_ip.get(i);
            for(int x : list){
                if(map_so.containsKey(x)) q.add(x);
            }
        }
        return res;
    }
}
