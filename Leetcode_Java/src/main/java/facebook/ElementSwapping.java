package facebook;

public class ElementSwapping {

    private int findMinAtDistanceK(int [] arr, int start, int k) {
        int index = 0, min = Integer.MAX_VALUE;
        // find minimum element at distance k from start
        for(int i=start; i <= start + k; i++) {
            if(arr[i] < min) {
                min = arr[i];
                index =i;
            }
        }
        return index;
    }

    private void swap(int [] arr, int start, int end) {
        //move element at position end to start
        while(end > start) {
            int temp = arr[end];
            arr[end] = arr[end-1];
            arr[end-1] = temp;
            end--;
        }
    }

    int[] findMinArray(int[] arr, int k) {
        // Write your code here
        for(int i =0; i < arr.length && k >0; i++) {
            int minIndex = findMinAtDistanceK(arr, i, k);
            //if minimum element is already at position i, nothing to do
            if(minIndex == i) {
                continue;
            }
            swap(arr, i, minIndex);
            // we have used up minindex-i swaps
            k -= minIndex - i;
        }
        return arr;

    }


}
