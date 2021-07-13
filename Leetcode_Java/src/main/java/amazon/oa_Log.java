package amazon;

import java.util.*;

/**
 * Created by yujiwei on 18/7/14.
 */
public class oa_Log {

    public static List<String> logReordering(String[] logs){

        List<String> numbericLogs = new ArrayList<>();
        List<String> characterLogs = new ArrayList<>();

        for(String log:logs){

            //seperate into two arrays
            String[] log_detail = log.split(" ");
            char c = log_detail[1].charAt(0);
            if(c >= '0' && c <= '9'){
                numbericLogs.add(log);
            }else{
                characterLogs.add(log);
            }
        }

        //reorder characterlogs
        int size1 = characterLogs.size();

        PriorityQueue<String> char_pq = new PriorityQueue<>(size1, new Comparator<String>() {
            @Override
            public int compare(String a, String b){
                String a_id = a.substring(0, a.indexOf(' '));
                String b_id = b.substring(0, a.indexOf(' '));
                String a_log =a.substring(a.indexOf(' ')+1);
                String b_log =b.substring(b.indexOf(' ')+1);

                System.out.println("a_id: "+a_id);
                System.out.println("b_id: "+b_id);
                System.out.println("a_log: "+a_log);
                System.out.println("b_log: "+b_log);

                System.out.println("a_log compare to b_log: "+a_log.compareTo(b_log));
                if(a_log.compareTo(b_log) == 0) System.out.println("a_id compare to b_id: "+a_id.compareTo(b_id));

                if(a_log.compareTo(b_log) > 0){
                    return 1;
                }else if(a_log.compareTo(b_log) < 0){
                    return -1;
                }else{
                    if(a_id.compareTo(b_id) > 0){
                        return 1;
                    }else if(a_id.compareTo(b_id) < 0){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            }
        });

        for(String char_log: characterLogs){
            char_pq.add(char_log);
        }

        //merge logs

        List<String> res = new ArrayList<>();

        Iterator<String> sorted_charlog = char_pq.iterator() ;
        while(sorted_charlog.hasNext() ) {
            res.add(sorted_charlog.next());
        }

        res.addAll(numbericLogs);
        return res;

    }


    public static void main(String[] args){

        String[] logs = {
                "a1 9 2 3 1",
                "g1 Act car",
                "zo4 4 7",
                "ab1 off KEY dog",
                "a8 act zoo"
        };

        List<String> res = logReordering(logs);

        for(String log:res){
            System.out.print("res: " + log + "\n");
        }

    }

}
