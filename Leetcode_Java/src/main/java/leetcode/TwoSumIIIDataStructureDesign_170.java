package leetcode;

import java.util.*;

public class TwoSumIIIDataStructureDesign_170 {

    //#1, more find , less add
    Set<Integer> sum;
    Set<Integer> num;

    TwoSumIIIDataStructureDesign_170(){
        sum = new HashSet<>();
        num = new HashSet<>();
    }

    public void add(int number){
        if(num.contains(number)){
            sum.add(number*2);
        }else{
            Iterator<Integer> iter = num.iterator();
            while(iter.hasNext()){
                sum.add(iter.next()+number);
            }
            num.add(number);
        }
    }

    public boolean find(int value){
        return sum.contains(value);
    }

    //#2, more add, less find
    Map<Integer, Integer> hm;

//    TwoSumIIIDataStructureDesign_170(){
//        hm = new HashMap<>();
//    }

    public void add_(int number){
        if(hm.containsKey(number)){
            hm.put(number, 2);
        }else{
            hm.put(number, 1);
        }
    }

    public boolean find_(int value){
        Iterator<Integer> iter = hm.keySet().iterator();
        while(iter.hasNext()){
            int num1 = iter.next();
            int num2 = value - num1;
            if(hm.containsKey(num2)){
                if(num1!=num2 || hm.get(num2)==2){
                    return true;
                }
            }
        }
        return false;
    }

}
