public class Solution3765 {
    public boolean completePrime(int num) {
        String s = String.valueOf(num);
        if (!isPrime(num)) return false;
        for (int i = 1; i < s.length(); i++) {
            int pre = Integer.parseInt(s.substring(0, i));
            int suf = Integer.parseInt(s.substring(i));
            if (!isPrime(pre) || !isPrime(suf)) return false;
        }
        return true;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; ++i) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
/*
3765. 完全质数
https://leetcode.cn/problems/complete-prime-number/description/

第 171 场双周赛 T1。

给你一个整数 num。
如果一个数 num 的每一个 前缀 和每一个 后缀 都是 质数，则称该数为 完全质数。
如果 num 是完全质数，返回 true，否则返回 false。
注意：
- 一个数的 前缀 是由该数的 前 k 位数字构成的。
- 一个数的 后缀 是由该数的 后 k 位数字构成的。
- 质数 是大于 1 且只有两个因子（1 和它本身）的自然数。
- 个位数只有在它是 质数 时才被视为完全质数。
提示：
1 <= num <= 10^9

模拟。
时间复杂度 O(sqrt(num))。
 */