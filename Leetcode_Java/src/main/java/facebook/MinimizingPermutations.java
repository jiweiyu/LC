package facebook;

public class MinimizingPermutations {

    private void reverseSubArray(int[] arr, int begin, int end) {
        for (int i = 0; i < (end - begin + 1) / 2; i++) {
            int temp = arr[begin + i];
            arr[begin + i] = arr[end - i];
            arr[end - i] = temp;
        }
    }

    private int findTarget(int[] arr, int end, int target) {
        for (int i = 0; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        throw new IllegalArgumentException("The input is invalid");
    }


    private int minOperations(int[] arr, int index) {
        if (index < 0) {
            return 0;
        }

        if (arr[index] == index + 1) {
            // this element is already in its final position
            return minOperations(arr, index - 1);
        } else {
            int begin = findTarget(arr, index, index + 1);
            reverseSubArray(arr, begin, index);
            return 1 + minOperations(arr, index - 1);
        }
    }


    int minOperations(int[] arr) {
        // Write your code here
        return minOperations(arr, arr.length - 1);
    }
}
