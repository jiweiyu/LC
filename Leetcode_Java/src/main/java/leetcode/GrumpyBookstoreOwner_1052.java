package leetcode;

public class GrumpyBookstoreOwner_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int save = 0; // currently how many customers change to be happy if using technique, sliding window
        int totalCustomer = 0; // sum of all customers
        int totalGrumpy = 0; // sum of all unsatisfied customers without using technique
        int maxSave = 0;
        for(int i = 0; i < n; i++) {
            totalCustomer += customers[i];
            totalGrumpy += customers[i] * grumpy[i];
            save += customers[i] * grumpy[i];
            if(i > X - 1) {
                save -= customers[i - X] * grumpy[i - X];
            }
            maxSave = Math.max(save, maxSave);
        }
        return totalCustomer - totalGrumpy + maxSave;
    }
}
