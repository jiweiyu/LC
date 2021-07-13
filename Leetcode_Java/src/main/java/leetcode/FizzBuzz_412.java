package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {

    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<>(n);
        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
            fizz++;
            buzz++;
            if(fizz==3 && buzz==5){
                ret.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }else if(fizz==3){
                ret.add("Fizz");
                fizz=0;
            }else if(buzz==5){
                ret.add("Buzz");
                buzz=0;
            }else{
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }

    public List<String> fizzBuzz_(int n) {
        List<String> res = new ArrayList<String>();
        for(int i=1;i<=n;i++){
            StringBuilder sb = new StringBuilder();
            if(i%3 == 0){
                sb.append("Fizz");
            }
            if(i%5 == 0){
                sb.append("Buzz");
            }
            if(i%3!=0 && i%5!=0){
                sb.append(i);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
