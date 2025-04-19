public class Solution3514 {
    // 253ms
    static class V1 {
        public int uniqueXorTriplets(int[] nums) {
            // int U = 1 << bitsLen(1500);
            final int U = 2048;

            boolean[] has = new boolean[U];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    has[nums[i] ^ nums[j]] = true;
                }
            }

            boolean[] has3 = new boolean[U];
            for (int xy = 0; xy < U; xy++) {
                if (!has[xy]) {
                    continue;
                }
                for (int z : nums) {
                    has3[xy ^ z] = true;
                }
            }

            int ans = 0;
            for (boolean b : has3) {
                if (b) ans++;
            }
            return ans;
        }
    }

    // 50ms
    static class V2 {
        // 快速沃尔什变换 https://oi-wiki.org/math/poly/fwt/
        private void fwtXOR(long[] a, int rsh) {
            int n = a.length;
            for (int l = 2, k = 1; l <= n; l <<= 1, k <<= 1) {
                for (int i = 0; i < n; i += l) {
                    for (int j = 0; j < k; j++) {
                        long aij = a[i + j], aijk = a[i + j + k];
                        a[i + j] = (aij + aijk) >> rsh;
                        a[i + j + k] = (aij - aijk) >> rsh;
                    }
                }
            }
        }

        private long[] fwtXOR3(long[] a) {
            fwtXOR(a, 0);
            for (int i = 0; i < a.length; i++) {
                long x = a[i];
                a[i] *= x * x;
            }
            fwtXOR(a, 1);
            return a;
        }

        public int uniqueXorTriplets(int[] nums) {
            // int U = 1 << bitsLen(1500);
            final int U = 2048;
            long[] cnt = new long[U];
            for (int x : nums) {
                cnt[x]++;
            }
            int ans = 0;
            for (long c : fwtXOR3(cnt)) {
                if (c > 0) ans++;
            }
            return ans;
        }
    }
}
/*
3514. 不同 XOR 三元组的数目 II
https://leetcode.cn/problems/number-of-unique-xor-triplets-ii/description/

第 154 场双周赛 T3。

给你一个整数数组 nums 。
XOR 三元组 定义为三个元素的异或值 nums[i] XOR nums[j] XOR nums[k]，其中 i <= j <= k。
返回所有可能三元组 (i, j, k) 中 不同 的 XOR 值的数量。
提示：
1 <= nums.length <= 1500
1 <= nums[i] <= 1500

循环优化，附 O(UlogU) FWT 做法
https://leetcode.cn/problems/number-of-unique-xor-triplets-ii/solutions/3649377/mei-ju-fu-oulogu-fwt-zuo-fa-pythonjavacg-69r3/
 */