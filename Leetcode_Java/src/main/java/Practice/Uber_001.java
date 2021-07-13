package Practice;

public class Uber_001 {

    public static int[] getArrayTrend(int[] A){
        int len = A.length-2;
        int[] B = null;
        if(len>0){
            B = new int[len];
        }

        for(int i=2;i<A.length;i++){
            if((A[i]<=A[i-1] && A[i-1]<=A[i-2]) || (A[i]>=A[i-1] && A[i-1]>=A[i-2])){
                B[i-2]=1;
            }else{
                B[i-2]=0;
            }
        }
        return B;
    }

    public static void main(String[] args){
        int[] A = new int[]{1,2,2,3,4,4,1,5};
        int[] B = getArrayTrend(A);
        System.out.println("check B: " + B.length);
        for(int b : B){
           System.out.println(b);
        }
    }
}
