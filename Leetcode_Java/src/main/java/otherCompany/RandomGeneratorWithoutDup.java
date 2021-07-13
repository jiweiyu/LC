package otherCompany;
import java.util.*;
public class RandomGeneratorWithoutDup {
    static Map<Integer, Integer> m;
    static Random r;
    static int wlen;
    static Set<Integer> picked;
    static int min_;
    static int max_;

    public RandomGeneratorWithoutDup(int size){
        m = new HashMap<>();
        r = new Random();
        wlen = size;
        min_ = 0;
        max_ = size;
        picked = new HashSet<>();
    }

    public RandomGeneratorWithoutDup(int min, int max){
        m = new HashMap<>();
        r = new Random();
        wlen = max - min + 1;
        min_ = min;
        max_ = max;
        picked = new HashSet<>();
    }

    public int pick(){
        int k = r.nextInt(wlen);
        while(picked.contains(k)){
            k = r.nextInt(wlen);
        }
        picked.add(k);
        return k;
    }

    public int pickInRange(){
        int k = r.nextInt(wlen) + min_;
        while(picked.contains(k)){
            k = r.nextInt(wlen) + min_;
        }
        picked.add(k);
        return k;
    }

    public static int checkPicked(){
        return picked.size();
    }

    public static void updateRange(int min, int max){
        wlen = max - min + 1;
        min_ = min;
    }

    //use HashMap to remap the black list element to available white list element
    public static void addBlackList(int[] b){
        wlen = max_ - b.length;
        for(int i = wlen; i < max_; i++){
            picked.add(i);
        }

        for(int x : b){
            picked.remove(x);
        }

        Iterator<Integer> pi = picked.iterator();
        for(int x : b){
            if(x < wlen){
                m.put(x, pi.next());
            }
        }
    }

    public static int pickPlus(){
        int k = r.nextInt(wlen);
        while(picked.contains(k)){
            k = r.nextInt(wlen);
        }
        picked.add(k);
        return m.getOrDefault(k, k);
    }


    public static void main(String[] args){
        RandomGeneratorWithoutDup obj = new RandomGeneratorWithoutDup(10);
        System.out.println(obj.pick() + ", check picked: " + checkPicked());
        System.out.println(obj.pick() + ", check picked: " + checkPicked());
        System.out.println(obj.pick() + ", check picked: " + checkPicked());
        System.out.println(obj.pick() + ", check picked: " + checkPicked());
        System.out.println(obj.pick() + ", check picked: " + checkPicked());

        RandomGeneratorWithoutDup obj_ = new RandomGeneratorWithoutDup(10, 20);
        System.out.println("check in range: " + obj_.pickInRange() + ", check picked: " + checkPicked());
        System.out.println("check in range: " + obj_.pickInRange() + ", check picked: " + checkPicked());
        System.out.println("check in range: " + obj_.pickInRange() + ", check picked: " + checkPicked());
        System.out.println("check in range: " + obj_.pickInRange() + ", check picked: " + checkPicked());
        System.out.println("check in range: " + obj_.pickInRange() + ", check picked: " + checkPicked());

        updateRange(15, 20);
        System.out.println("check in range: " + obj_.pickInRange() + ", check picked: " + checkPicked());
        System.out.println("check in range: " + obj_.pickInRange() + ", check picked: " + checkPicked());
        System.out.println("check in range: " + obj_.pickInRange() + ", check picked: " + checkPicked());
        System.out.println("check in range: " + obj_.pickInRange() + ", check picked: " + checkPicked());
        System.out.println("check in range: " + obj_.pickInRange() + ", check picked: " + checkPicked());

        RandomGeneratorWithoutDup objplus = new RandomGeneratorWithoutDup(20);
        objplus.addBlackList(new int[]{5,15,20});
        System.out.println("check pickplus: " + objplus.pickPlus() + ", check picked: " + checkPicked());
        System.out.println("check pickplus: " + objplus.pickPlus() + ", check picked: " + checkPicked());
        System.out.println("check pickplus: " + objplus.pickPlus() + ", check picked: " + checkPicked());
        System.out.println("check pickplus: " + objplus.pickPlus() + ", check picked: " + checkPicked());
        System.out.println("check pickplus: " + objplus.pickPlus() + ", check picked: " + checkPicked());

    }

}
