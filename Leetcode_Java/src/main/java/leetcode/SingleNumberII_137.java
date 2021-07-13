package leetcode;

public class SingleNumberII_137 {


    //https://leetcode.com/problems/single-number-ii/discuss/43295/Detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers
    public int singleNumber_(int[] nums) {
        int x1 = 0, x2 = 0, mask = 0;

        for (int i : nums) {
            x2 ^= x1 & i;
            x1 ^= i;
            mask = ~(x1 & x2);
            x2 &= mask;
            x1 &= mask;
        }

        return x1;  // Since p = 1, in binary form p = '01', then p1 = 1, so we should return x1.
        // If p = 2, in binary form p = '10', then p2 = 1, and we should return x2.
        // Or alternatively we can simply return (x1 | x2).
    }

    //这里的 ab 就是上面的三种状态 00，01，10 的十位和各位，刚开始的时候，a和b都是0，
    // 当此时遇到数字1的时候，b更新为1，a更新为0，就是 01 的状态；
    // 再次遇到1的时候，b更新为0，a更新为1，就是 10 的状态；
    // 再次遇到1的时候，b更新为0，a更新为0，就是 00 的状态，相当于重置了；
    // 最后的结果保存在b中
    public int singleNumber(int[] nums) {
            int a = 0, b = 0;
            for (int i = 0; i < nums.length; ++i) {
                b = (b ^ nums[i]) & ~a;
                a = (a ^ nums[i]) & ~b;
            }
            return b;
    }
}
