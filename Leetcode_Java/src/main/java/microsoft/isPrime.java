package microsoft;

public class isPrime {

    public boolean isPrime(int x){
        boolean res = false;
        int i = 1;
        while(i <= x/2){
            if(x%i == 0){
                res = true;
                break;
            }
            i++;
        }
        return res;
    }
}
