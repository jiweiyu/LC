package leetcode;

public class XOROperationInAnArray_1486 {
    public int xorOperation(int n, int start) {
        //nums[i] = start + 2*i

        int res = start;
        for(int i = 1;i<n;i++){
            res = res^(start+2*i);
        }
        return res;
    }
}
