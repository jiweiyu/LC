package leetcode;



public class SearchInASortedArrayOfUnknownSize_702 {

    class ArrayReader {
        public int get(int index) {
            return index; //jiwei added, should be empty implementation
        }
    }

    public int search(ArrayReader reader, int target){
        int hi = 1;
        while(reader.get(hi)<target){
            hi = hi<<1; //while get(hi) < target, double hi
        } //final hi will >target

        int low = hi>>1; //low is hi/2
        while(low<=hi){
            int mid = low+(hi-low)/2;
            if(reader.get(mid)>target){
                hi = mid-1;
            }else if(reader.get(mid)<target){
                low = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }


}

