package leetcode;

public class FlippingAnImage_832 {

    public int[][] flipAndInvertImage(int[][] A) {
        for(int[] row: A){
            row=helper(row);
        }
        return A;
    }

    public int[] helper(int[] row){
        int i=0, j=row.length-1;
        while(i<=j){
            if(i==j){
                row[i]=(~row[i])&1;
            }else{
                int tmp = row[i];
                row[i] = (~row[j])&1;
                row[j] = (~tmp)&1;
            }
            i++;
            j--;
        }
        return row;
    }
}
