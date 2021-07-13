package leetcode;

public class SortArrayByParity_905 {
    public int[] sortArrayByParity(int[] A) {
        int s = 0, e = A.length-1;
        while(s < e){
            while(A[s]%2 == 0 && s < e){
                s++;
            }
            while(A[e]%2 == 1 && s < e){
                e--;
            }
            swap(A, s, e);
            s++;
            e--;
        }
        return A;
    }

    void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
