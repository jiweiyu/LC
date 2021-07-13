package leetcode;

public class SortArrayByParityII_922 {

    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int even = 0, odd = 1;
        for(int a : A){
            if(a%2 == 0){
                res[even] = a;
                even += 2;
            }else{
                res[odd] = a;
                odd += 2;
            }
        }
        return res;
    }
}
