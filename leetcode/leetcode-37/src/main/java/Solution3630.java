import java.util.Arrays;

public class Solution3630 {
    public long maximizeXorAndXor(int[] nums) {
        int n = nums.length;
        int maxVal = Arrays.stream(nums).max().orElseThrow();
        int sz = 32 - Integer.numberOfLeadingZeros(maxVal);

        // 预处理所有子集的 AND 和 XOR（刷表法）
        int u = 1 << n;
        int[] subAnd = new int[u];
        int[] subXor = new int[u];
        subAnd[0] = -1;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int highBit = 1 << i;
            for (int mask = 0; mask < highBit; mask++) {
                subAnd[highBit | mask] = subAnd[mask] & x;
                subXor[highBit | mask] = subXor[mask] ^ x;
            }
        }
        subAnd[0] = 0;

        long ans = 0;
        for (int i = 0; i < u; i++) {
            int j = (u - 1) ^ i;
            ans = Math.max(ans, subAnd[i] + maxXor2(j, subXor[j], nums, sz));
        }
        return ans;
    }

    private long maxXor2(int sub, int xor, int[] nums, int sz) {
        XorBasis b = new XorBasis(sz);
        for (int i = 0; i < nums.length; i++) {
            if ((sub >> i & 1) > 0) {
                // 只考虑有偶数个 1 的比特位（xor 在这些比特位上是 0）
                b.insert(nums[i] & ~xor);
            }
        }
        return xor + b.maxXor() * 2L;
    }


    // 线性基模板
    static class XorBasis {
        private final int[] b;

        public XorBasis(int n) {
            b = new int[n];
        }

        public void insert(int x) {
            while (x > 0) {
                int i = 31 - Integer.numberOfLeadingZeros(x); // x 的最高位
                if (b[i] == 0) { // x 和之前的基是线性无关的
                    b[i] = x; // 新增一个基，最高位为 i
                    return;
                }
                x ^= b[i]; // 保证参与 maxXor 的基的最高位是互不相同的，方便我们贪心
            }
            // 正常循环结束，此时 x=0，说明一开始的 x 可以被已有基表出，不是一个线性无关基
        }

        public int maxXor() {
            int res = 0;
            // 从高到低贪心：越高的位，越必须是 1
            // 由于每个位的基至多一个，所以每个位只需考虑异或一个基，若能变大，则异或之
            for (int i = b.length - 1; i >= 0; i--) {
                res = Math.max(res, res ^ b[i]);
            }
            return res;
        }
    }
}
/*
3630. 划分数组得到最大异或运算和与运算之和
https://leetcode.cn/problems/partition-array-for-maximum-xor-and-and/description/

第 460 场周赛 T4。

给你一个整数数组 nums。
将数组划分为 三 个（可以为空）子序列 A、B 和 C，使得 nums 中的每个元素 恰好 属于一个子序列。
你的目标是 最大化 以下值：XOR(A) + AND(B) + XOR(C)
其中：
- XOR(arr) 表示 arr 中所有元素的按位异或结果。如果 arr 为空，结果定义为 0。
- AND(arr) 表示 arr 中所有元素的按位与结果。如果 arr 为空，结果定义为 0。
返回可实现的最 大 值。
注意: 如果有多种划分方式得到相同的 最大 和，你可以按其中任何一种划分。
子序列 是指一个数组通过删除一些或不删除任何元素，不改变剩余元素的顺序得到的元素序列。
提示:
1 <= nums.length <= 19
1 <= nums[i] <= 10^9

线性基（线性异或基）
式子变形 + 线性基 + 最优性剪枝 https://leetcode.cn/problems/partition-array-for-maximum-xor-and-and/submissions/649144010/
如果直接三进制枚举，时间复杂度是 O(3^n) = 3^19 = 1,162,261,467 = 1e9
rating 2747 (clist.by)
 */