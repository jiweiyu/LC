package leetcode;

public class PowerOfFour_342 {
    public boolean isPowerOfFour_bit(int num) {
        return Integer.bitCount(num) == 1 && (Integer.toBinaryString(num).length()-1)%2==0;
    }

    //power of two: x > 0 and x & (x - 1) == 0

    public boolean isPowerOfFour_bitAndMath(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
    }
}
