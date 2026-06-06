import java.util.Arrays;

public class Solution3918 {
    static class V1 {
        public int sumOfPrimesInRange(int n) {
            int r = Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());
            int ans = 0;
            for (int i = Math.min(n, r); i <= Math.max(n, r); i++) {
                if (isPrime(i)) ans += i;
            }
            return ans;
        }

        private boolean isPrime(int n) {
            if (n < 2) return false;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // O(logn)
    static class V2 {
        private static final int MX = 1001;
        private static final int[] isPrime = new int[MX];

        static {
            Arrays.fill(isPrime, 2, MX, 1);
            for (int i = 2; i * i < MX; i++) {
                if (isPrime[i] > 0) {
                    for (int j = i * i; j < MX; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
            // 原地计算 isPrime 的质数前缀和
            for (int i = 1; i < MX; i++) {
                isPrime[i] = isPrime[i - 1] + (isPrime[i] > 0 ? i : 0);
            }
        }

        public int sumOfPrimesInRange(int n) {
            int r = 0;
            for (int x = n; x > 0; x /= 10) {
                r = r * 10 + x % 10;
            }
            return isPrime[Math.max(n, r)] - isPrime[Math.min(n, r) - 1];
        }
    }
}
/*
3918. 数与其逆序数之间的质数和
https://leetcode.cn/problems/sum-of-primes-between-number-and-its-reverse/description/

第 500 场周赛 T2。

给你一个整数 n。
令 r 为将 n 的数字反转后得到的整数。
返回从 min(n, r) 到 max(n, r)（包含两端）之间所有 质数 的 总和。
提示：
1 <= n <= 1000

枚举。
时间复杂度 O(n)。
 */