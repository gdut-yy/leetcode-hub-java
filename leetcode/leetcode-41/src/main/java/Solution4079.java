import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution4079 {
    private static final int MX = 1_000_001;
    private static final boolean[] isPrime = new boolean[MX];
    private static final List<Integer> primes = new ArrayList<>();
    private static final List<Long> sum = new ArrayList<>();

    static {
        Arrays.fill(isPrime, true);
        long s = 0;
        for (int i = 2; i < MX; i++) {
            if (isPrime[i]) {
                primes.add(i);
                s += i;
                sum.add(s);
                for (long j = (long) i * i; j < MX; j += i) {
                    isPrime[(int) j] = false; // j 是质数 i 的倍数
                }
            }
        }
    }

    public List<Integer> maxPrimes(int n, int s) {
        int i = Collections.binarySearch(primes, n + 1);
        if (i < 0) i = ~i; // 见 Collections.binarySearch 源码

        int j = Collections.binarySearch(sum.subList(0, i), (long) s + 1);
        if (j < 0) j = ~j;

        return primes.subList(0, j);
    }
}
/*
4079. 选择质数子集 I
https://leetcode.cn/problems/prime-subset-selection-i/description/

第 523 场周赛 T2。

给你两个整数 n 和 s。
考虑所有小于等于 n 的 质数。从中选择一些质数，并满足以下条件：
- 所选质数的 总和 小于等于 s。
- 所选质数的数量 最多 。
- 每个质数 最多只能选择一次 。
返回一个包含所选质数的整数数组，并按 递增 顺序排列。如果存在多个最优选择，返回其中 任意一个 即可。
如果无法选择任何质数，则返回一个 空 数组。
质数 是大于 1 且只有 1 和它本身两个因数的自然数。
示例 1：
输入： n = 7, s = 20
输出： [2,3,5,7]
示例 2：
输入： n = 15, s = 15
输出： [3,5,7]
示例 3：
输入： n = 5, s = 1
输出： []
提示：
1 <= n <= 10^6
1 <= s <= 10^9

预处理。
 */